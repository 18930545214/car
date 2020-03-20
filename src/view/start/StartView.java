package view.start;

import util.InputUtil;

/**
 * 二嗨主界面
 */
public class StartView {
    public void start(){
        System.out.println("===============");
        System.out.println("欢迎访问二嗨租车");
        System.out.println("===============");
        boolean flag = true;
        while(true) {
            System.out.println("1.登录 2.注册 0.退出");
            String choose = InputUtil.next();
            switch (choose) {
                case "1":
                    new LoginView().start();
                    break;
                case "2":
                    new RegisterView().start();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误,请重新输入!");
                    break;
            }
        }
    }
}
