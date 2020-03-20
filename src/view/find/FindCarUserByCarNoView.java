package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.CarUser;
import entity.User;
import util.HintUtil;

import java.util.List;

/**
 * 根据汽车编码查询租赁记录
 */
public class FindCarUserByCarNoView {
    private HintUtil hint = new HintUtil();
    public void start(String result, User user){
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarUserByCarNo#"+result;
        String x = tcpClient.connectAndSendMsg(request);
        List<CarUser> list1 = JSON.parseArray(x, CarUser.class);
        if (list1!=null){
            hint.carUser(user);
            for (CarUser caruser:list1) {
                System.out.println(caruser);
            }
        }else {
            System.out.println("没有查到对应租赁记录");
        }

    }
}
