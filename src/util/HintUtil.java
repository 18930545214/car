package util;

import entity.User;

/**
 * 这边是些重复的输出语句
 */
public class HintUtil {
    public void car(User user){
        if(user.getAdminNo()==1){
            System.out.println("============================================================================================");
            System.out.println("编号\t汽车名称\t备注\t\t品牌\t\t类型\t\t\t租金\t\t是否可租(0:已租 1:可租)\t是否上架(0:下架 1:上架)");

        }else {
            System.out.println("================================================================");
            System.out.println("编号\t汽车名称\t备注\t\t品牌\t\t类型\t\t租金\t\t是否可租(0:已租 1:可租)");
        }

    }
    public void carUser(User user) {
        if (user.getAdminNo() == 1) {
            System.out.println("========================================================================================================================================================");
            System.out.println("编号\t\t汽车编号\t汽车名称\t\t用户编号\t用户名\t每日租金\t租金总额\t\t备注\t\t\t品牌\t\t\t类型\t\t\t\t借车时间\t\t\t\t\t\t还车时间");

        } else {
            System.out.println("==========================================================================================================================");
            System.out.println("编号\t\t汽车编号\t汽车名称\t\t每日租金\t租金总额\t\t备注\t\t\t品牌\t\t\t类型\t\t\t\t借车时间\t\t\t\t\t\t还车时间");
        }
    }
}
