package service;

import dao.ConsumerDao;
import dao.IConsumerDao;
import entity.Car;
import entity.CarUser;
import entity.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**客户
 * 1. 查询汽车
 * 2. 查询租车记录
 * 3. 租车
 * 4. 还车
 */
public class ConsumerService implements IConsumerService{
    private IConsumerDao consumerDao = new ConsumerDao();
    private IFindCarService findCar = new FindCarService();



    @Override
    public int borrowCar(int id, User user) {//借车
        Connection conn = null;
        try {
            Car car = findCar.findCarById(id, user);
            if (car.getHire()==1){
                Timestamp time = new Timestamp(new Date().getTime());//获取当前时间
                conn = ConnectionFactory.getConnection();//建立连接
                conn.setAutoCommit(false);//设置事务为手动提交模式
                int b = consumerDao.setHireCar(0, id,conn);//修改汽车为不可租;
                int a = consumerDao.borrowCar(car,user,time,conn);//租车,生成一条记录
                if (a == 0) {
                    throw new Exception();
                }
                if (b == 0) {
                    throw new Exception();
                }

                return a;
            }else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();//回滚事务
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }finally {
            try {
                conn.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionFactory.close(conn);//断开连接
        }
        return 0;
    }

    @Override
    public int repayCar(int id) {//还车
        Connection conn = null;
        try {
            CarUser carUser = findCar.findCarUserById(id);//获取记录表;
            int carNo = carUser.getCarId();//汽车编号
            int rent = carUser.getRent();//每日租金
            Timestamp borrowTime = carUser.getBorrowTime();//借车时间
            Timestamp repayTime = new Timestamp(new Date().getTime());//还车时间
            //datediff(repayTime,borrowTime);
            long j = ((repayTime.getTime() - borrowTime.getTime())/(1000*60))/24/60;//时间差 单位:小时
            Double price = (double)((j+1)*rent);//租金总额,不满一天按一天算
            if(carUser.getRepayTime()==null) {
                conn = ConnectionFactory.getConnection();//建立连接
                conn.setAutoCommit(false);//设置事务为手动提交模式
                int a = consumerDao.repayCar(id,price,repayTime,conn);//给记录表上的归还时间赋值;
                int b = consumerDao.setHireCar(1,carNo,conn);//修改汽车为可租;
                if (a == 0) {
                    throw new Exception();
                }
                if (b == 0) {
                    throw new Exception();
                }
                return a;
            }else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();//回滚事务
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }finally {
            try {
                conn.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionFactory.close(conn);//断开连接
        }
        return 0;

    }
}
