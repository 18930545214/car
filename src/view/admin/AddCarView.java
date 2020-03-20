package view.admin;

import client.TCPClient;
import com.alibaba.fastjson.JSON;
import entity.Brand;
import entity.Car;
import entity.Type;
import util.InputUtil;

import java.util.List;


/**
 * 管理员
 * 添加汽车
 */
public class AddCarView {
    public void start() {
        System.out.println("========================");
        System.out.println("请分别输入以下信息");
        System.out.println("------------------------");
        System.out.println("品牌如下:");
        System.out.println("品牌编号:    品牌名:");
        TCPClient tcpClient = new TCPClient();
        String s = tcpClient.connectAndSendMsg("FindCarBrand#");
        List<Brand> list = JSON.parseArray(s, Brand.class);//查询品牌表
        for (Brand brand :list) { System.out.println(brand);}
        System.out.println("请选择品牌编号:");
        int id = InputUtil.nextInt();
        String request = "FindCarBrandById#"+id;
        String x = tcpClient.connectAndSendMsg(request);
        Brand brand = JSON.parseObject(x, Brand.class);//查询品牌表按编码
        //Brand brand = new FindCarService().findBrand(id);//按输入的编码再次查询
        System.out.println("------------------------");
        System.out.println("类型如下:");
        System.out.println("类型编号:    类型名:");
        String z = tcpClient.connectAndSendMsg("FindCarType#");
        List<Type> list1 = JSON.parseArray(z, Type.class);//查询品牌表
        for (Type type :list1) { System.out.println(type);}
        System.out.println("请选择类型编号:");
        int i = InputUtil.nextInt();
        String request1 = "FindCarTypeById#"+i;
        String y = tcpClient.connectAndSendMsg(request1);
        Type type = JSON.parseObject(y, Type.class);//查询品牌表按编码
        System.out.println("型号:");
        String name = InputUtil.next();
        System.out.println("------------------------");
        System.out.println("车牌号:");
        String carNo = InputUtil.next();
        System.out.println("------------------------");
        System.out.println("概要:");
        String remark = InputUtil.next();
        System.out.println("------------------------");
        System.out.println("每日租金:(单位/元)");
        int rent = InputUtil.nextInt();
        System.out.println("------------------------");
        System.out.println("汽车价格:(单位/元)");
        int price = InputUtil.nextInt();
        System.out.println("------------------------");
        System.out.println("颜色:");
        String colour = InputUtil.next();
        System.out.println("------------------------");
        System.out.println("是否可租(1:可租 2:不可租)");
        int hire = InputUtil.nextInt();
        System.out.println("------------------------");
        System.out.println("是否上架(1:上架 2:下架)");
        int putaway = InputUtil.nextInt();
        if(brand!=null&&type!=null) {
            Car car = new Car(0, name, remark, brand.getName() + "(" + brand.getId() + ")", type.getName() + "(" + type.getId() + ")", rent, price, hire, putaway, colour, carNo);
            //调用业务逻辑层完成添加汽车
            String request2 = "AddCar#"+ JSON.toJSONString(car);
            String m = tcpClient.connectAndSendMsg(request2);
            int ros = Integer.parseInt(m);
            if (ros > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        }else {
            System.out.println("添加失败,品牌或类型不存在");
        }
    }
}
