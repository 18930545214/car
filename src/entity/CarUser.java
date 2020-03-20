package entity;


import java.sql.Timestamp;

public class CarUser {
    private int id;//编号
    private int carId;//汽车编号
    private String carName;//汽车名字
    private int userId;//用户编码
    private String userName;//用户名
    private int rent;//每日租金
    private double price;//租金总额
    private String remark;//备注;
    private String brand;//品牌;
    private String type;//类型;
    private Timestamp borrowTime;//借车时间;
    private Timestamp repayTime;//还车时间


    public CarUser(){}
    public CarUser(int id, int carId, String carName, int userId, String userName, int rent, double price, String remark, String brand, String type, Timestamp borrowTime, Timestamp repayTime) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.userId = userId;
        this.userName = userName;
        this.rent = rent;
        this.price = price;
        this.remark = remark;
        this.brand = brand;
        this.type = type;
        this.borrowTime = borrowTime;
        this.repayTime = repayTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(Timestamp repayTime) {
        this.repayTime = repayTime;
    }

    @Override
    public String toString() {
        return
                id + "\t"+ "\t"
                + carId + "\t" + "\t"
                + carName + "\t" + "\t"
                + userId + "\t" + "\t"
                + userName + "\t" + "\t"
                + rent + "\t" + "\t"
                + price + "\t"+ "\t"
                + remark + "\t"+ "\t"
                + brand + "\t"+ "\t"
                + type + "\t"+ "\t"
                + borrowTime + "\t"+ "\t"
                + repayTime ;
    }
    public String getString() {
        return
                id + "\t"+ "\t"
                + carId + "\t" + "\t"
                + carName + "\t" + "\t"
                + rent + "\t" + "\t"
                + price + "\t"+ "\t"
                + remark + "\t"+ "\t"
                + brand + "\t"+ "\t"
                + type + "\t"+ "\t"
                + borrowTime + "\t"+ "\t"
                + repayTime ;
    }
}
