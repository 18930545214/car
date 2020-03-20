package service;

import dao.IUserDao;
import dao.UserDao;
import entity.User;

/**
 * 登陆注册
 */
public class UserService implements IUserService {
    private IUserDao userDao = new UserDao();
    //返回null表示登录失败
    @Override
    public User login(User user) {
        try {
            //登录业务
            //查找账户密码是否正确的
            return userDao.findUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//错误返回空
    }

    @Override
    public User post(User user) {
        try {
            //注册账号
            //用来判断账号是否存在
            return userDao.findUsers(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(User user1) {
        try {
            //注册一个普通账号
            //返回一个大于0的数即代表注册成功
            return userDao.addUser(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;//异常返回0;
    }
}
