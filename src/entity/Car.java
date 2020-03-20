package entity;

import util.HintUtil;

public class Car {
    private int id;//编号
    private String name;//汽车名字
    private String remark;//备注
    private String brand;//品牌
    private String type;//类型
    private int rent;//租金
    private int price;//价格
    private int hire;//是否可租(1.可租 0.不可租)
    private int putaway;//是否上架(1.上架 0.下架)
    private String colour;//颜色
    private String carNo;//车牌号



    public Car(){}

    public Car(int id, String name, String remark, String brand, String type, int rent, int price, int hire, int putaway, String colour, String carNo) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.brand = brand;
        this.type = type;
        this.rent = rent;
        this.price = price;
        this.hire = hire;
        this.putaway = putaway;
        this.colour = colour;
        this.carNo = carNo;
    }
    public Car(int id, String name, String remark, String brand, String type, int rent, int price, int hire, String colour, String carNo) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.brand = brand;
        this.type = type;
        this.rent = rent;
        this.price = price;
        this.hire = hire;
        this.colour = colour;
        this.carNo = carNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHire() {
        return hire;
    }

    public void setHire(int hire) {
        this.hire = hire;
    }

    public int getPutaway() {
        return putaway;
    }

    public void setPutaway(int putaway) {
        this.putaway = putaway;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Override
    public String toString() {
            return  id +"\t" +
                    name + "\t" +
                    remark + "\t" +
                    brand + "\t" +
                    type + "\t" +
                    rent + "\t" +"\t" +
                    hire  +"\t" +"\t" +"\t" +"\t" +"\t" +"\t" +
                    putaway ;

    }
    public String getString(){//用于客户使用
            return  id + "\t" +
                    name + "\t" +
                    remark + "\t" +
                    brand + "\t" +
                    type + "\t" +
                    rent + "\t" + "\t" +
                    hire ;


    }
}
