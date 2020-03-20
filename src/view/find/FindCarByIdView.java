package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.HintUtil;
import util.InputUtil;
import view.admin.SetCarView;
import view.consumer.BorrowCarView;

/**
 * 按汽车编码查询
 */
public class FindCarByIdView {
    private HintUtil hint = new HintUtil();
    public void start(String s,User user){
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarById#"+ JSON.toJSONString(user)+"#"+s;
        String x = tcpClient.connectAndSendMsg(request);
        Car car1 = JSON.parseObject(x, Car.class);
        if (car1!=null) {
            if (user.getAdminNo() == 1) {//管理员
                hint.car(user);
                    System.out.println(car1);
                System.out.println("1.修改这辆车  0.退出");
                int choose = InputUtil.nextInt();
                if (choose == 1){
                    new SetCarView().start(s,user);
                }else {
                    System.out.println("");
                }
            } else {//客户
                hint.car(user);
                    System.out.println(car1.getString());
                System.out.println("1.租这辆车  0.退出");
                int choose = InputUtil.nextInt();
                if (choose == 1){
                    new BorrowCarView().start(s,user);
                }else {
                    System.out.println("");
                }
            }
        }else {
            System.out.println("查找失败");
        }
    }
}
