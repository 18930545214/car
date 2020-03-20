package view.admin;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Car;
import entity.User;
import util.HintUtil;
import util.InputUtil;

/**
 * 管理员
 * 修改车辆信息
 */
public class SetCarView {
    public void start(String result, User user) {
        //调用管理员按编号查询功能
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarById#"+ JSON.toJSONString(user)+"#"+result;
        String x = tcpClient.connectAndSendMsg(request);
        Car car = JSON.parseObject(x, Car.class);
        if (car != null) {
            new HintUtil().car(user);
            System.out.println(car);
            System.out.println("请输入你要修改的内容编号: 1.租凭价格 2.上架下架");
            int choose = InputUtil.nextInt();
            if (choose == 1) {
                new SetCatRentView().start(result.substring(2),user);
            } else if (choose == 2) {
                if(car.getHire()==1) {
                    new SetCarPutawayView().start(result.substring(2), user);
                }else {
                    System.out.println("汽车已被租走,暂不提供修改");
                }
            } else {
                System.out.println("输入错误,请重新输入");
            }
        } else {
            System.out.println("没有这辆车");
        }
    }
}
