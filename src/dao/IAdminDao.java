package dao;


import entity.Brand;
import entity.Car;
import entity.CarUser;
import entity.Type;

import java.util.List;

/**
 * 管理员
 */

public interface IAdminDao {
    public int addCar(Car car) throws Exception;//添加汽车
    public int deleteCar(int id)throws Exception;//删除汽车
    public int setRentCar(int id,int rent) throws Exception;//修改汽车租金
    public int setPutawayCar(int id,int putaway) throws Exception;//修改汽车上架下架
}
