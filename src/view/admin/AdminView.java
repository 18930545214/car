package view.admin;

import entity.User;
import util.InputUtil;
import view.find.*;

/**
 * 管理员
 * 1.查询汽车
 * 2.修改汽车信息
 * 3.添加汽车
 */
public class AdminView {
    public void start(User result){
        System.out.println("==============二嗨租车================");
        System.out.println("=====================================");
        new FindCarAllView().start(result);//默认查询
        boolean flag = true;
        while (flag) {
            System.out.println("输入0退出");
            System.out.println("输入1+汽车编码 查看指定汽车 如1+2");
            System.out.println("输入2+1 按价格降序排序 2+2 按价格升序排序");
            System.out.println("输入3+类型编码 按类型搜索");
            System.out.println("输入4+品牌编号 按品牌查询");
            System.out.println("输入5 查看全部汽车");
            System.out.println("输入6 添加汽车");
            System.out.println("输入7+汽车编码 修改汽车信息");
            System.out.println("输入8 查看汽车记录");
            System.out.println("输入9+汽车编码 删除汽车");
            String choose = InputUtil.next();
            if (choose.equals("0")){
                flag = false;
            }else if(choose.charAt(0)=='1'){//
                if (choose.charAt(1)=='+'&&choose.length()>2)
                new FindCarByIdView().start(choose.substring(2),result);
            }else if(choose.charAt(0)=='2'){//排序
                if (choose.charAt(1)=='+'&&choose.length()>2)
                new SortByPriceView().start(choose.substring(2),result);
            }else if(choose.charAt(0)=='3'){//按类型编码查询
                if (choose.charAt(1)=='+'&&choose.length()>2)
                new FindCarByTypeView().start(choose.substring(2),result);
            }else if(choose.charAt(0)=='4'){//按品牌编码查询
                if (choose.charAt(1)=='+'&&choose.length()>2)
                new FindCarByBrandView().start(choose.substring(2),result);
            }else if(choose.charAt(0)=='5'){//查询所有汽车
                new FindCarAllView().start(result);
            }else if(choose.charAt(0)=='6'){//添加汽车
                new AddCarView().start();
            }else if(choose.charAt(0)=='7') {//修改汽车信息
                if (choose.charAt(1)=='+'&&choose.length()>2)
                new SetCarView().start(choose.substring(2),result);
            }else if (choose.charAt(0)=='8'){//查询所有租车记录
                new FindCarUserView().start(result);
            }else if (choose.charAt(0)=='9'){//删除汽车
                new DeleteCarView().start(choose.substring(2));
            }else {//非法输入
                System.out.println("输入有误,请重新输入");
            }
        }

    }
}
