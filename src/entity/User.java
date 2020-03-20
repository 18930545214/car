package entity;

public class User {
    private int id;//编号
    private String username;//账号
    private String password;//密码
    private int adminNo;//管理权限(1.有 0.无)

    public User(){}

    public User(int id, String username, String password,int adminNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adminNo = adminNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminNo=" + adminNo +
                '}';
    }
}
