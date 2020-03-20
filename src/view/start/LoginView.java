package view.start;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.User;
import service.IUserService;
import service.UserService;
import util.InputUtil;
import view.admin.AdminView;
import view.consumer.ConsumerView;

/**
 * 登陆
 */
public class LoginView {
    private String name = null;
    public void start(){
        boolean flag = true;
        while(flag) {
            System.out.println("============>>>>");
            System.out.println("用户名:");
            String username = InputUtil.next();
            System.out.println("密码:");
            String password = InputUtil.next();
            //调用业务逻辑层来完成登录功能
            System.out.println("正在登陆,请稍后...");
            User user = new User(0, username, password,0);
            TCPClient tcpClient = new TCPClient();
            String request = "Login#"+JSON.toJSONString(user);
            String s = tcpClient.connectAndSendMsg(request);
            User result = JSON.parseObject(s, User.class);
            System.out.println("==================");
            if (result !=null) {
                if (result.getAdminNo() == 1) {
                    System.out.println("尊敬的" + result.getUsername() + "管理员你好!欢迎使用二嗨租车");
                    //管理员登陆成功
                    new AdminView().start(result);
                    flag = false;
                } else {
                    System.out.println("尊敬的" + result.getUsername()+"欢迎使用二嗨租车");
                    //用户登录成功
                    name = username;
                    new ConsumerView().start(result);
                    flag = false;
                }
            } else {//失败
                System.out.println("用户名或密码错误,登录失败!");
                System.out.println("1.重新登录 0.返回上一级");
                String choose = InputUtil.next();
                switch (choose) {
                    case "1":
                        //继续登录
                        break;
                    case "0":
                        flag = false;//结束循环
                        break;
                    default:
                        System.out.println("输入有误,请重新输入!");
                        break;
                }
            }
        }
    }
}
