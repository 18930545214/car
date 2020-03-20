package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandleRunnable implements Runnable {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private String ip;

    public ServerHandleRunnable(Socket socket) {
        this.socket = socket;
        ip = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        try {
            //获取输入流,包装
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取输出流,包装
            pw = new PrintWriter(socket.getOutputStream(), true);
            //读一行--接收客户端发送的请求
            String request = br.readLine();
            //处理请求--不同的请求要做不同的处理
            System.out.println("来自 " + ip + "的" + request);
            //调用处理请求的方法,得到响应
            String response = handleRequest(request);
            //写一行--把处理的结果作为响应发送给客户端
            pw.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //处理请求,返回响应
    public static String handleRequest(String request){
        HandleRequest hand = new HandleRequest();
        //不同的请求要做不同的处理, 调用业务逻辑层来处理
        String[] array = request.split("#");
        switch(array[0]){
            case "Login"://管理员登录
                return hand.login(array);
            case "Post"://查询账号是否存在
                return hand.post(array);
            case "Register"://注册
                return hand.register(array);
            case "FindCarAll"://查询所有汽车
                return hand.findCarAll(array);
            case "SortByPrice"://排序
                return hand.sortByPrice(array);
            case "FindCarById"://按汽车编码查找汽车
                return hand.findCarById(array);
            case "FindCarByType"://按类型编码查找汽车
                return hand.findCarByType(array);
            case "FindCarByBrand"://按品牌编码查找汽车
                return hand.findCarByBrand(array);
            case "FindCarUser"://查询租赁记录
                return hand.findCarUser(array);
            case "FindCarUserByCarNo"://按汽车编号查询租赁记录
                return hand.findCarUserByCarNo(array);
            case "FindCarUserByUserNo"://按用户编码查询租赁记录
                return hand.findCarUserByUserNo(array);
            case "AddCar"://添加汽车
                return hand.addCar(array);
            case "SetCarPutaway"://修改上架下架
                return hand.setCarPutaway(array);
            case "SetCarRent"://修改租金
                return hand.setCarRent(array);
            case "DeleteCar"://删除汽车
                return hand.deleteCar(array);
            case "BorrowCar"://租车
                return hand.borrowCar(array);
            case "RepayCar"://还车
                return hand.repayCar(array);
            case "FindCarBrand"://查询品牌
                return hand.findCarBrand();
            case "FindCarType"://查查类型
                return hand.findCarType();
            case "FindCarBrandById"://查询品牌按品牌编号
                return hand.findCarBrandById(array);
            case "FindCarTypeById"://查查类型按类型编号
                return hand.findCarTypeById(array);

        }
        return null;
    }
}
