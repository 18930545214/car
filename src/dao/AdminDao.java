package dao;

import entity.*;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员
 */
public class AdminDao implements IAdminDao{

    @Override
    public int addCar(Car car) throws Exception{//添加汽车
        Connection conn = ConnectionFactory.getConnection();
        String sql = "insert into t_car values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,car.getId());
        pstmt.setString(2,car.getName());
        pstmt.setString(3,car.getRemark());
        pstmt.setString(4,car.getBrand());
        pstmt.setString(5,car.getType());
        pstmt.setInt(6,car.getRent());
        pstmt.setInt(7,car.getPrice());
        pstmt.setInt(8,car.getHire());
        pstmt.setInt(9,car.getPutaway());
        pstmt.setString(10,car.getColour());
        pstmt.setString(11,car.getCarNo());
        int ros = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt,conn);
        return ros;

    }

    @Override
    public int deleteCar(int id) throws Exception {//删除汽车
        Connection conn = ConnectionFactory.getConnection();
        String sql = "delete from t_car where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        int ros = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt,conn);
        return ros;
    }


    @Override
    public int setRentCar(int id,int rent) throws Exception {//修改租金
        Connection conn = ConnectionFactory.getConnection();
        String sql = "update t_car set rent=? where id =?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,rent);
        pstmt.setInt(2,id);
        int result = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt,conn);
        return result;
    }

    @Override
    public int setPutawayCar(int id,int putaway) throws Exception {//修改上架下架
        Connection conn = ConnectionFactory.getConnection();
        String sql = "update t_car set putaway=? where id =?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,putaway);
        pstmt.setInt(2,id);
        int ros = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt,conn);
        return ros;
    }
}
