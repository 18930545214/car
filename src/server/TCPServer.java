package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端程序
public class TCPServer {
    //服务器套接字对象
    private ServerSocket serverSocket = null;
    private int port;

    public TCPServer(int port){
        this.port = port;
    }

    public TCPServer(){
        this.port = 6666;//如果不指定端口号,默认6666
    }

    public void start() {
        try {
            //1.创建服务器套接字对象,指定服务器端端口号
            serverSocket = new ServerSocket(port);
            System.out.println("服务器启动成功");
            //2.不断等待客户端连接请求
            while(true){
                //连接成功,返回套接字Socket对象,负责与对应的客户端交互
                Socket socket = serverSocket.accept();
                //交互,传递数据,可能是耗时的,通过新的线程来完成,不影响下一个连接请求
                //获取客户端的ip地址
                System.out.println(socket.getInetAddress().getHostAddress()+"连接成功");
                //创建新的线程,启动新线程
                Thread thread = new Thread(new ServerHandleRunnable(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //创建TCPServer对象
        TCPServer tcpServer = new TCPServer();
        //启动服务器
        tcpServer.start();
    }
}
