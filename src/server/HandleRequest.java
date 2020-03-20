package server;

import com.alibaba.fastjson.JSON;
import entity.*;
import service.*;

import java.util.List;

public class HandleRequest {
    IFindCarService find = new FindCarService();

    public String login(String[] array){//登陆
        //把第二个字符串还原成Admin对象
        User user = JSON.parseObject(array[1], User.class);
        //调用业务逻辑层的方法,验证登录
        User login = new UserService().login(user);
        return JSON.toJSONString(login);
    }
    public String findCarAll(String[] array){//查询所有汽车
        User user = JSON.parseObject(array[1], User.class);
        List<Car> carByAll = find.findCarByAll(user);
        return JSON.toJSONString(carByAll);
    }
    public String sortByPrice(String[] array){//排序
        User user = JSON.parseObject(array[1], User.class);
        String sv = array[2];
        int id = Integer.parseInt(sv);
        List<Car> list1 = find.sortByPrice(id, user);
        return JSON.toJSONString(list1);
    }
    public String findCarById(String[] array){//汽车按编号查询
        User user = JSON.parseObject(array[1], User.class);
        int id = Integer.parseInt(array[2]);
        Car car = find.findCarById(id, user);
        return JSON.toJSONString(car);
    }
    public String findCarByType(String[] array){//按类型编号查询
        User user = JSON.parseObject(array[1], User.class);
        String sv = array[2];
        List<Car> carByType = find.findCarByType(sv, user);
        return JSON.toJSONString(carByType);
    }
    public String findCarByBrand(String[] array){//按品牌编号查询
        User user = JSON.parseObject(array[1], User.class);
        String sv = array[2];
        List<Car> carByBrand = find.findCarByBrand(sv, user);
        return JSON.toJSONString(carByBrand);
    }
    public String findCarUserByCarNo(String[] array){//按汽车编号查询租赁记录
        String sv = array[1];
        int id = Integer.parseInt(sv);
        List<CarUser> carUserByCarNo = find.findCarUserByCarNo(id);
        return JSON.toJSONString(carUserByCarNo);
    }
    public String findCarUserByUserNo(String[] array){//按用户编号查询租赁记录
        String sv = array[1];
        int id = Integer.parseInt(sv);
        List<CarUser> carUserByUserNo = find.findCarUserByUserNo(id);
        return JSON.toJSONString(carUserByUserNo);
    }
    public String findCarUser(String[] array) {//查询租赁记录
        User user = JSON.parseObject(array[1], User.class);
        List<CarUser> carUser = find.findCarUser(user);
        return JSON.toJSONString(carUser);
    }
    public String findCarType() {//查询汽车类型
        List<Type> type = find.findType();
        return JSON.toJSONString(type);

    }
    public String findCarTypeById(String[] array) {//查询汽车类型按类型编号
        int id = Integer.parseInt(array[1]);
        Type type = find.findType(id);
        return JSON.toJSONString(type);
    }
    public String findCarBrand() {//查询汽车品牌
        List<Brand> brand = find.findBrand();
        return JSON.toJSONString(brand);
    }
    public String findCarBrandById(String[] array) {//查询汽车品牌按品牌编号
        int id = Integer.parseInt(array[1]);
        Brand brand = find.findBrand(id);
        return JSON.toJSONString(brand);
    }
    public String register(String[] array){//注册
        User user = JSON.parseObject(array[1], User.class);
        int i = new UserService().addUser(user);
        return JSON.toJSONString(i);
    }
    public String addCar(String[] array){//添加汽车
        Car car = JSON.parseObject(array[1], Car.class);
        int i = new AdminService().addCar(car);
        return JSON.toJSONString(i);
    }
    public String borrowCar(String[] array){//租车
        User user = JSON.parseObject(array[1], User.class);
        int id = Integer.parseInt(array[2]);
        int i = new ConsumerService().borrowCar(id, user);
        return JSON.toJSONString(i);
    }
    public String repayCar(String[] array){//还车
        int id = Integer.parseInt(array[1]);
        int i = new ConsumerService().repayCar(id);
        return JSON.toJSONString(i);
    }
    public String deleteCar(String[] array){//删除车
        int id = Integer.parseInt(array[1]);
        int i = new AdminService().deleteCar(id);
        return JSON.toJSONString(i);
    }
    public String setCarPutaway(String[] array){//修改车上架下架
        int id = Integer.parseInt(array[1]);
        int putaway = Integer.parseInt(array[2]);
        int i = new AdminService().setPutawayCar(id, putaway);
        return JSON.toJSONString(i);
    }
    public String setCarRent(String[] array){//修改车租金
        int id = Integer.parseInt(array[1]);
        int rent = Integer.parseInt(array[2]);
        int i = new AdminService().setRentCar(id, rent);
        return JSON.toJSONString(i);
    }

    public String post(String[] array) {//查询账号是否存在
        User user = JSON.parseObject(array[1], User.class);
        User post = new UserService().post(user);
        return JSON.toJSONString(post);
    }

}

