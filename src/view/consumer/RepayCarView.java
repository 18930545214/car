package view.consumer;

import client.TCPClient;
import entity.CarUser;
import entity.User;
import service.FindCarService;
import service.IFindCarService;
import util.HintUtil;

/**
 * 客户
 * 还车
 */
public class RepayCarView {
    private IFindCarService findCar = new FindCarService();
    public void start(String result,User user){
        int id = Integer.parseInt(result.substring(2));
        TCPClient tcpClient = new TCPClient();
        String request = "RepayCar#"+result;
        String s = tcpClient.connectAndSendMsg(request);
        int ros = Integer.parseInt(s);
        if(ros>0){
            System.out.println("还车成功信息如下");
            new HintUtil().carUser(user);
            CarUser carUser = findCar.findCarUserById(id);
            System.out.println(carUser.getString());
        }else {
            System.out.println("还车失败");
        }

    }
}
