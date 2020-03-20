package service;

import entity.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 查询汽车表
 */
public interface IFindCarService {
    public List<Car> findCarByAll(User user);//查询全部
    public Car findCarById(int id,User user);//按汽车编码查询
    public List<Car> findCarByType(String type,User user);//按类型编码查询
    public List<Car> findCarByBrand(String brand,User user);//按品牌编码查询
    public List<Car> sortByPrice(int result,User user) ;//排序
    public List<CarUser> findCarUser(User user);//查询所有汽车租赁记录
    public List<CarUser> findCarUserByCarNo(int carNo);//按汽车编号查询租赁记录
    public List<CarUser> findCarUserByUserNo(int userNo);//按客户编号查询租赁记录
    public CarUser findCarUserById(int id);//根据记录编码查询记录
    public CarUser findCarUser();//查询租赁记录最后一条,用于租车完成后展示给客户
    public List<Brand> findBrand();//查询品牌
    public List<Type> findType();//查询编码
    public Brand findBrand(int id);//查询品牌按编号
    public Type findType(int id);//查询编码按编号
}
