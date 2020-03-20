package dao;

import entity.*;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询汽车
 * 查询租赁记录
 * 查询品牌
 * 查询类型
 * 排序
 */
public class FindCarDao implements IFindCarDao {
    private List<Car> list = new ArrayList<>();
    private List<CarUser> list1 = new ArrayList<>();
    private List<Brand> list2 = new ArrayList<>();
    private List<Type> list3 = new ArrayList<>();
    private Brand brand = new Brand();
    private Type type = new Type();
    private Car car = new Car();

    @Override
    public List<Car> findCarByAll(String sql) throws Exception {//查找全部
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(new Car(
                            (rs.getInt(1)),
                            (rs.getString(2)),
                            (rs.getString(3)),
                            (rs.getString(4)),
                            (rs.getString(5)),
                            (rs.getInt(6)),
                            (rs.getInt(7)),
                            (rs.getInt(8)),
                            (rs.getInt(9)),
                            (rs.getString(10)),
                            (rs.getString(11))
                    )
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list;
    }

    @Override
    public Car findCarById(String sql, int id) throws Exception {//按编号查询
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            car = new Car(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getInt(9),
                    rs.getString(10),
                    rs.getString(11)

            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return car;
    }

    @Override
    public List<Car> findCarByType(String sql, String type) throws Exception {//按类型编号查询
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"%"+type+"%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(new Car(
                            (rs.getInt(1)),
                            (rs.getString(2)),
                            (rs.getString(3)),
                            (rs.getString(4)),
                            (rs.getString(5)),
                            (rs.getInt(6)),
                            (rs.getInt(7)),
                            (rs.getInt(8)),
                            (rs.getInt(9)),
                            (rs.getString(10)),
                            (rs.getString(11))
                    )
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list;
    }

    @Override
    public List<Car> findCarByBrand(String sql, String brand) throws Exception {//按品牌编号查询
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"%"+brand+"%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(new Car(
                            (rs.getInt(1)),
                            (rs.getString(2)),
                            (rs.getString(3)),
                            (rs.getString(4)),
                            (rs.getString(5)),
                            (rs.getInt(6)),
                            (rs.getInt(7)),
                            (rs.getInt(8)),
                            (rs.getInt(9)),
                            (rs.getString(10)),
                            (rs.getString(11))
                    )
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list;
    }

    @Override
    public List<Car> sortByPrice(String sql) throws Exception {//排序
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(new Car(
                            (rs.getInt(1)),
                            (rs.getString(2)),
                            (rs.getString(3)),
                            (rs.getString(4)),
                            (rs.getString(5)),
                            (rs.getInt(6)),
                            (rs.getInt(7)),
                            (rs.getInt(8)),
                            (rs.getInt(9)),
                            (rs.getString(10)),
                            (rs.getString(11))
                    )
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list;
    }

    @Override
    public List<CarUser> findCarUser(String sql,int userId) throws Exception {//查询租车记录
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,userId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list1.add(new CarUser(
                    (rs.getInt(1)),
                    (rs.getInt(2)),
                    (rs.getString(3)),
                    (rs.getInt(4)) ,
                    (rs.getString(5)),
                    (rs.getInt(6) ),
                    (rs.getDouble(7)),
                    (rs.getString(8)) ,
                    (rs.getString(9) ),
                    (rs.getString(10)),
                    (rs.getTimestamp(11)),
                    (rs.getTimestamp(12))
            ));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list1;
    }

    @Override
    public List<CarUser> findCarUserByCarNo(int carNo) throws Exception {//按汽车编号查询租赁记录
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_caruser where car_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,carNo);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list1.add(new CarUser(
                    (rs.getInt(1)),
                    (rs.getInt(2)),
                    (rs.getString(3)),
                    (rs.getInt(4)) ,
                    (rs.getString(5)),
                    (rs.getInt(6) ),
                    (rs.getDouble(7)),
                    (rs.getString(8)) ,
                    (rs.getString(9) ),
                    (rs.getString(10)),
                    (rs.getTimestamp(11)),
                    (rs.getTimestamp(12))
            ));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list1;
    }

    @Override
    public List<CarUser> findCarUserByUserNo(int userNo) throws Exception {//按用户编号查询租赁记录
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_caruser where user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,userNo);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list1.add(new CarUser(
                    (rs.getInt(1)),
                    (rs.getInt(2)),
                    (rs.getString(3)),
                    (rs.getInt(4)) ,
                    (rs.getString(5)),
                    (rs.getInt(6) ),
                    (rs.getDouble(7)),
                    (rs.getString(8)) ,
                    (rs.getString(9) ),
                    (rs.getString(10)),
                    (rs.getTimestamp(11)),
                    (rs.getTimestamp(12))
            ));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list1;
    }

    @Override
    public CarUser findCarUserById(int id) throws Exception {//按记录编号查询记录
        CarUser carUser = new CarUser();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_caruser where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            carUser = new CarUser(rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3) ,
                    rs.getInt(4) ,
                    rs.getString(5),
                    rs.getInt(6) ,
                    rs.getDouble(7) ,
                    rs.getString(8) ,
                    rs.getString(9) ,
                    rs.getString(10),
                    rs.getTimestamp(11) ,
                    rs.getTimestamp(12)
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return carUser;
    }

    @Override
    public CarUser findCarUser() throws Exception {//租车记录最后一条
        CarUser carUser = new CarUser();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_caruser order by id desc limit 1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            carUser = new CarUser(rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3) ,
                    rs.getInt(4) ,
                    rs.getString(5),
                    rs.getInt(6) ,
                    rs.getDouble(7) ,
                    rs.getString(8) ,
                    rs.getString(9) ,
                    rs.getString(10),
                    rs.getTimestamp(11) ,
                    rs.getTimestamp(12)
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return carUser;
    }

    @Override
    public List<Brand> findBrand() throws Exception {//查询品牌
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list2.add(new Brand(
                    (rs.getInt(1)),
                    (rs.getString(2))
            ));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return list2;
    }

    @Override
    public List<Type> findType() throws Exception {//查询类型
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_type";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list3.add(new Type(
                    (rs.getInt(1)),
                    (rs.getString(2))
            ));
        }
        ConnectionFactory.close(rs, pstmt, conn);
        return list3;
    }

    @Override
    public Brand findBrand(int id) throws Exception {//按编号查询品牌
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_brand where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            brand = new Brand(
                    rs.getInt(1),
                    rs.getString(2)
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return brand;
    }

    @Override
    public Type findType(int id) throws Exception {//按编号查询类型
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select * from t_type where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            type = new Type(
                    rs.getInt(1),
                    rs.getString(2)
            );
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return type;
    }
}
