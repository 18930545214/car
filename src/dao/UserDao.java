package dao;

import entity.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 账号管理
 */
public class UserDao implements IUserDao {
    @Override
    public User findUser(User user) throws Exception {//判断账号密码是否存在,完成登录
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select id,username,password,admin_no from t_user " +
                "where username=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        User result = null;
        if(rs.next()){
            result = new User(rs.getInt(1),
                    rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return result;

    }

    public User findUsers(User user) throws Exception {//判断账号是否存在,完成注册
        Connection conn = ConnectionFactory.getConnection();
        String sql = "select id,username,password,admin_no from t_user " +
                "where username=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        User result = null;
        if(rs.next()){
              result = new User(rs.getInt(1),
                    rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        ConnectionFactory.close(rs,pstmt,conn);
        return result;
    }

    @Override
    public int addUser(User user1) throws Exception{//注册一个新的账号
        Connection conn = ConnectionFactory.getConnection();
        String sql = "insert into t_user(username,password) values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user1.getUsername());
        pstmt.setString(2,user1.getPassword());
        int ros = pstmt.executeUpdate();
        ConnectionFactory.close(pstmt,conn);
        return ros;
    }
}
