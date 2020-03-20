package view.consumer;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.CarUser;
import entity.User;
import service.FindCarService;
import service.IFindCarService;
import util.HintUtil;


/**
 * 客户
 * 租车
 */
public class BorrowCarView {
    private IFindCarService findCar = new FindCarService();
    public void start(String result,User user){
        TCPClient tcpClient = new TCPClient();
        String request = "BorrowCar#"+ JSON.toJSONString(user)+"#"+result;
        String s = tcpClient.connectAndSendMsg(request);
        int ros = Integer.parseInt(s);
        if(ros>0){
            System.out.println("租车成功,信息如下");
            new HintUtil().carUser(user);
            CarUser carUser = findCar.findCarUser();
            System.out.println(carUser.getString());
        }else {
            System.out.println("租车失败,汽车已被租走");
        }
    }
}
