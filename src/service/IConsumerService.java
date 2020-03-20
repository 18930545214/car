package service;

import entity.CarUser;
import entity.User;


/**
 * 客户功能
 */
public interface IConsumerService {

    //用户只能查询未租的和已上架的
    public int borrowCar(int id, User user);//3. 租车
    public int repayCar(int id);//4. 还车
}
