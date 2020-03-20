package dao;

import entity.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

/**
 * 查询汽车表
 */
public interface IFindCarDao {
    public List<Car> findCarByAll(String sql)throws Exception;//查询全部
    public Car findCarById(String sql,int id)throws Exception;//按汽车编码查询
    public List<Car> findCarByType(String sql,String type)throws Exception;//按类型编码查询
    public List<Car> findCarByBrand(String sql,String brand)throws Exception;//按品牌编码查询
    public List<Car> sortByPrice(String sql) throws Exception;//排序
    public List<CarUser> findCarUser(String sql,int userId)throws Exception;//查询所有汽车租赁记录
    public List<CarUser> findCarUserByCarNo(int carNo)throws Exception;//按汽车编号查询租赁记录
    public List<CarUser> findCarUserByUserNo(int userNo)throws Exception;//按客户编号查询租赁记录
    public CarUser findCarUserById(int id)throws Exception;//根据记录编码查询租赁记录
    public CarUser findCarUser()throws Exception;//查询租赁记录最后一条,用于租车完成后展示给客户
    public List<Brand> findBrand()throws Exception;//查询品牌
    public List<Type> findType()throws Exception;//查询编码
    public Brand findBrand(int id)throws Exception;//查询品牌按编号
    public Type findType(int id)throws Exception;//查询编码按编号

}
