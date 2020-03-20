package view.admin;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.InputUtil;
import util.HintUtil;

/**
 * 修改租金
 */
public class SetCatRentView {
    public void start(String id, User user) {//修改租金
        System.out.println("请输入新的租凭价格:");
        int rent = InputUtil.nextInt();
        TCPClient tcpClient = new TCPClient();
        String request = "SetCarRent#"+id+"#"+rent;
        String x = tcpClient.connectAndSendMsg(request);
        int ros = Integer.parseInt(x);
        if (ros> 0) {
            System.out.println("修改成功,当前租金是" + rent + "/天");
            new HintUtil().car(user);//提示
            String request1 = "FindCarById#"+ JSON.toJSONString(user)+"#"+id;
            String z = tcpClient.connectAndSendMsg(request1);
            Car car = JSON.parseObject(z, Car.class);//再次查询展示
            System.out.println(car);
        } else {
            System.out.println("修改失败");

        }
    }
}
