package service;

import entity.User;

/**
 * 登陆注册
 */
public interface IUserService {
    //登录
    public User login(User user);

    //注册,判断账号是不是存在
    public User post(User user);
    //注册,添加一个用户进去
    public int addUser(User user1);
}
