package service;

import entity.Brand;
import entity.Car;
import entity.CarUser;
import entity.Type;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员功能
 */
public interface IAdminService {
    //("1.查询汽车 2.修改汽车信息 3.添加汽车 0.退出");
    //管理员默认查询所有汽车
    public int setRentCar(int id,int rent);//修改汽车租金功能
    public int setPutawayCar(int id,int putaway);//修改汽车上架下架功能
    public int addCar(Car car);//添加汽车功能
    public int deleteCar(int id);//删除汽车

}
