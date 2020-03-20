package util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ConnectionFactory {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    //静态代码块--类加载时执行,只会执行一次
    static{
        //把属性文件中的四个值读取到内存存储起来
        //1.创建Properties集合对象
        Properties prop = new Properties();
        //2.加载属性文件中的键值对信息到prop对象
        //要求:ConnnectionFactory和jdbc_info.properties同包
        try {
            prop.load(ConnectionFactory.class.
                    getResourceAsStream("jdbc_info.properties"));
            //3.获取四个值
            driver  = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName(driver);
        //2.与数据库建立连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }



    public static void close(Connection conn) {
        close(null,null,conn);
    }

    public static void close(PreparedStatement pstmt) {
        close(null,pstmt,null);
    }




}
