package dao;

import entity.Car;
import entity.CarUser;
import entity.User;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

/**
 * 客户
 */
public interface IConsumerDao {
    public int borrowCar(Car car, User user,Timestamp time, Connection conn)throws Exception;//3. 租车
    public int repayCar(int id,Double price,Timestamp time,Connection conn)throws Exception;//4. 还车
    public int setHireCar(int hire,int id,Connection conn)throws Exception;//修改汽车是否可租;
}
