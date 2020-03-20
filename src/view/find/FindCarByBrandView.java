package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.HintUtil;

import java.util.List;

/**
 * 按品牌查询
 */
public class FindCarByBrandView {
    private HintUtil hint = new HintUtil();
    public void start(String brand,User user){
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarByBrand#"+ JSON.toJSONString(user)+"#"+brand;
        String x = tcpClient.connectAndSendMsg(request);
        List<Car> list1 = JSON.parseArray(x, Car.class);
        if(list1!=null) {
            if (user.getAdminNo() == 1) {//管理员
                hint.car(user);
                for (Car car:list1) {
                    System.out.println(car);
                }
            } else {//客户
                hint.car(user);
                for (Car car:list1) {
                    System.out.println(car.getString());
                }
            }
        }else {
            System.out.println("查找失败");
        }

    }

}
