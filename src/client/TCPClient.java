package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//客户端程序
public class TCPClient {
    private String serverIP;
    private int serverPort;
    private PrintWriter pw;
    private BufferedReader br;

    public TCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public TCPClient() {
        serverIP = "127.0.0.1";//默认连接到本机
        serverPort = 6666;//默认端口号
    }

    public String connectAndSendMsg(String request) {
        //1.创建套接字对象,与服务器端建立连接,指定服务器ip地址,端口号
        //如果创建成功,表示连接成功,抛异常连接失败
        Socket socket = null;
        try {
            //本机回环测试ip: 127.0.0.1
            socket = new Socket(serverIP, serverPort);
            //2.交互
            //输出流,true:自动刷新缓冲区
            pw = new PrintWriter(socket.getOutputStream(), true);
            //输入流,读取一行字符
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //写操作--发送请求给服务器端
            pw.println(request);
            //读操作--接收服务器端的响应
            String response = br.readLine();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭,释放系统资源
            if (pw != null) {
                pw.close();
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
