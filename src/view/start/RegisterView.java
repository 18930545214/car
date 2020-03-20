package view.start;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.User;
import service.IUserService;
import service.UserService;
import util.InputUtil;

/**
 * 注册一
 */
public class RegisterView {
    public void start(){
        System.out.println("用户名:");
        String username = InputUtil.next();
        System.out.println("密码:");
        String password = InputUtil.next();
        //只传账号过去,调用业务逻辑层来完成注册功能
        User user = new User(0,username,null,0);
        TCPClient tcpClient = new TCPClient();
        String request = "Post#"+ JSON.toJSONString(user);
        String s = tcpClient.connectAndSendMsg(request);
        User result = JSON.parseObject(s, User.class);
        if(result == null){//等于空可以注册
            User user1 = new User(0,username,password,0);
            String ss = "Register#"+ JSON.toJSONString(user1);
            String x = tcpClient.connectAndSendMsg(ss);
            int ros = Integer.parseInt(x);
            if(ros>0){
                System.out.println("注册成功,你可以登陆了");
            }
        }else{
            //账号已存在
            System.out.println("注册失败,账号已存在");
        }
    }
}
