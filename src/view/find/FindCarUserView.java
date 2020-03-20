package view.find;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.CarUser;
import entity.User;
import util.InputUtil;
import view.consumer.RepayCarView;
import util.HintUtil;

import java.util.List;

/**
 * 租车记录
 */
public class FindCarUserView {
    private boolean flag = true;
    private HintUtil hint = new HintUtil();
    public void start(User user) {
        TCPClient tcpClient = new TCPClient();
        String request = "FindCarUser#"+JSON.toJSONString(user);
        String x = tcpClient.connectAndSendMsg(request);
        List<CarUser> list1 = JSON.parseArray(x, CarUser.class);
        if (list1 != null) {
            if (user.getAdminNo() == 1) {
                hint.carUser(user);//提示输出
                for (CarUser caruser:list1) {
                    System.out.println(caruser);
                }
                while (flag) {
                    System.out.println("输入0 退出");
                    System.out.println("输入5 查看全部汽车");
                    System.out.println("输入6 全部租赁记录");
                    System.out.println("输入7+用户编号 查看指定用户租赁记录");
                    System.out.println("输入8+汽车编号 查看指定汽车租赁记录");
                    String choose = InputUtil.next();
                    if (choose.equals("0")) {
                        flag = false;
                        break;
                    } else if (choose.charAt(0) == '5') {
                        new FindCarAllView().start(user);
                    } else if (choose.charAt(0) == '6') {
                        new FindCarUserView().start(user);
                    } else if (choose.charAt(0) == '7') {
                        if (choose.length()>2)
                        new FindCarUserByUserNoView().start(choose.substring(2),user);
                    } else if (choose.charAt(0) == '8') {
                        if (choose.length()>2)
                        new FindCarUserByCarNoView().start(choose.substring(2), user);
                    }else {
                        System.out.println("输入有误,请重新输入");
                    }
                }
            } else {//客户
                hint.carUser(user);
                for (CarUser caruser:list1) {
                    System.out.println(caruser.getString());
                }
                while (true) {
                    System.out.println("输入0 退出");
                    System.out.println("输入5 查看全部汽车");
                    System.out.println("输入6 查看我的租车记录");
                    System.out.println("输入7+记录编号 还车");
                    String choose = InputUtil.next();
                    if (choose.equals("0")) {
                        flag = false;
                        break;
                    } else if (choose.charAt(0) == '5') {
                        new FindCarAllView().start(user);
                    } else if (choose.charAt(0) == '6') {
                        new FindCarUserView().start(user);
                    } else if (choose.charAt(0) == '7') {
                        new RepayCarView().start(choose.substring(2), user);
                    }else {
                        System.out.println("输入有误,请重新输入");
                    }
                }
            }
        }
    }
}
