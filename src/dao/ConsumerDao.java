package dao;

import entity.Car;
import entity.CarUser;
import entity.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户
 * 1.租赁汽车
 * 2.归还汽车
 */
public class ConsumerDao implements IConsumerDao{
    private List<Car> list = new ArrayList<>();
    Car car = null;
    CarUser carUser = null;

    @Override
    public int borrowCar(Car car, User user, Timestamp time, Connection conn) throws Exception {//借车
        String sql = "insert into t_caruser values(?,?,?,?,?,?,?,?,?,?,?,?)";
        //insert into t_caruser
        //values(0,7,'baoma',6,'tom',6,88.8,'自动1.8T','大众','suv','2019-12-03 22:11:21','2019-12-04 22:11:21')
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,0);
        pstmt.setInt(2,car.getId());
        pstmt.setString(3,car.getName());
        pstmt.setInt(4,user.getId());
        pstmt.setString(5,user.getUsername());
        pstmt.setInt(6,car.getRent());
        pstmt.setDouble(7,0.00);
        pstmt.setString(8,car.getRemark());
        pstmt.setString(9,car.getBrand());
        pstmt.setString(10,car.getType());
        pstmt.setTimestamp(11,time);
        pstmt.setTimestamp(12,null);
        int result = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt);
        return result;
    }

    @Override
    public int repayCar(int id, Double price,Timestamp time,Connection conn) throws Exception {//还车
        String sql = "update t_caruser set repay_time=?,price=? where id =?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setTimestamp(1,time);
        pstmt.setDouble(2,price);
        pstmt.setInt(3,id);
        int result = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt);
        return result;

    }


    @Override
    public int setHireCar(int hire,int id,Connection conn) throws Exception{//修改是否可租
        String sql = "update t_car set hire=? where id =?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,hire);
        pstmt.setInt(2,id);
        int result = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt);
        return result;
    }

}
