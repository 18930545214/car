package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.HintUtil;

import java.util.List;

public class SortByPriceView {
    private HintUtil hint = new HintUtil();
    public void start(String result,User user){
        TCPClient tcpClient = new TCPClient();
        String request = "SortByPrice#"+ JSON.toJSONString(user)+"#"+result;
        String s = tcpClient.connectAndSendMsg(request);
        List<Car> list1 = JSON.parseArray(s, Car.class);
        if(list1!=null) {
            if (user.getAdminNo() == 1) {//管理员
                hint.car(user);
                for (Car car : list1
                ) {
                    System.out.println(car);
                }
            } else {//客户
                hint.car(user);
                for (Car car : list1
                ) {
                    System.out.println(car.getString());
                }
            }
        }else {
            System.out.println("失败");
        }
    }
}
