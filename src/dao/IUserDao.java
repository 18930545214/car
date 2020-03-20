package dao;

import entity.User;

/**
 * 登陆注册
 */
public interface IUserDao {
    public User findUser(User user) throws Exception;//判断账号密码,用来登陆
    public User findUsers(User user) throws Exception;//判断账号,避免注册重复数据
    public int addUser(User user1) throws Exception;//注册一个普通账号
}
