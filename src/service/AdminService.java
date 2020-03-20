package service;

import dao.AdminDao;
import dao.IAdminDao;
import entity.Brand;
import entity.Car;
import entity.CarUser;
import entity.Type;

import java.util.List;


/**
 * 管理员
 * 1.删除汽车
 * 2.修改汽车信息
 * 3.添加汽车
 */
public class AdminService implements IAdminService{
    private IAdminDao adminDao = new AdminDao();

    @Override
    public int setRentCar(int id,int rent) {//修改价格
        try {
            return adminDao.setRentCar(id,rent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int setPutawayCar(int id,int putaway) {//修改汽车上架下架
        try {
            return adminDao.setPutawayCar(id,putaway);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addCar(Car car) {//增加
        try {
            return adminDao.addCar(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteCar(int id) {//删除汽车
        try {
            return adminDao.deleteCar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
