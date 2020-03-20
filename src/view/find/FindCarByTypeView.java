package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import service.*;
import util.InputUtil;
import util.HintUtil;

import java.util.List;

/**
 * 按类型查找
 * 提供排序方法
 */
public class FindCarByTypeView {
    private HintUtil hint = new HintUtil();
    public void start(String type,User user){
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarByType#"+ JSON.toJSONString(user)+"#"+type;
        String x = tcpClient.connectAndSendMsg(request);
        List<Car> list1 = JSON.parseArray(x, Car.class);
        if(list1!=null) {
            if (user.getAdminNo() == 1) {//管理员
                hint.car(user);
                for (Car car:list1
                ) {
                    System.out.println(car);
                }
            } else {//客户
                hint.car(user);
                for (Car car:list1
                ) {
                    System.out.println(car.getString());
                }
            }
        }else {
            System.out.println("没有查到对应汽车");
        }

    }
}
