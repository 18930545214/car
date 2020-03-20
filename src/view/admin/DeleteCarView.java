package view.admin;

import client.TCPClient;

/**
 * 删除汽车
 */
public class DeleteCarView {
    public void start(String s){
        TCPClient tcpClient = new TCPClient();
        String request = "DeleteCar#"+s.substring(2);
        String x = tcpClient.connectAndSendMsg(request);
        int ros = Integer.parseInt(x);
        if (ros>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
