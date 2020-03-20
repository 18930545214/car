package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.HintUtil;
import java.util.List;

/**
 * 默认查询
 * 查询所有
 */
public class FindCarAllView {
    private HintUtil hint = new HintUtil();
    public void start(User user){
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarAll#"+ JSON.toJSONString(user);
        String s = tcpClient.connectAndSendMsg(request);
        List<Car> list1 = JSON.parseArray(s, Car.class);//查询所有汽车
        if (list1!=null) {
            if (user.getAdminNo() == 1) {//管理员
                hint.car(user);
                for (Car car : list1) {
                    System.out.println(car);
                }
            } else {//客户
                hint.car(user);//提示
                for (Car car : list1) {
                    System.out.println(car.getString());
                }
            }
        }else {
            System.out.println("查找失败");
        }

    }
}
