package view.admin;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.InputUtil;
import util.HintUtil;

/**
 * 修改上架下架
 */
public class SetCarPutawayView {
    private HintUtil hint = new HintUtil();

    public void start(String id, User user) {//修改上架下架
        while (true) {
            System.out.println("请输入你要修改的内容编号 0.下架  1.上架 ");
            int putaway = InputUtil.nextInt();
            if (putaway == 1 || putaway == 0) {
                String s = putaway == 1 ? "上架" : "下架";
                TCPClient tcpClient = new TCPClient();
                String request = "SetCarPutaway#"+id+"#"+putaway;
                String x = tcpClient.connectAndSendMsg(request);
                int ros = Integer.parseInt(x);
                if (ros > 0) {
                    System.out.println("修改成功,商品已" + s);
                    hint.car(user);
                    String request1 = "FindCarById#"+ JSON.toJSONString(user)+"#"+id;
                    String z = tcpClient.connectAndSendMsg(request1);
                    Car car1 = JSON.parseObject(z, Car.class);
                    System.out.println(car1);//再次输出展示
                    break;
                } else {
                    System.out.println("修改失败");
                    break;
                }
            } else {
                System.out.println("输入有误,请重新输入");
            }
        }

    }
}
