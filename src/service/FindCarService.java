package service;

import dao.FindCarDao;
import dao.IFindCarDao;
import entity.*;

import java.sql.Timestamp;
import java.util.List;
/**
 * 查询汽车
 * 查询租赁记录
 * 查询品牌
 * 查询类型
 * 排序
 */
public class FindCarService implements IFindCarService {
    IFindCarDao findCarDao = new FindCarDao();
    @Override
    public List<Car> findCarByAll(User user)  {//查询全部
        String sql1 = "select * from t_car";
        String sql2 = "select * from t_car where putaway = 1";
        if (user.getAdminNo()==1){
            try {
                return findCarDao.findCarByAll(sql1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                return findCarDao.findCarByAll(sql2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Car findCarById(int id,User user) {//按汽车编码查询
        String sql1 = "select * from t_car where id = ?";
        String sql2 = "select * from t_car where id = ? and putaway = 1";
        if (user.getAdminNo()==1){
            try {
                return findCarDao.findCarById(sql1,id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                return findCarDao.findCarById(sql2,id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> findCarByType(String type,User user) {//按类型编码查询
        String sql1 = "select * from t_car where type like ?";
        String sql2 = "select * from t_car where type like ? and putaway = 1";
        if (user.getAdminNo()==1){
            try {
                return findCarDao.findCarByType(sql1,type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                return findCarDao.findCarByType(sql2,type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> findCarByBrand(String brand,User user)  {//按品牌编码查询
        String sql1 = "select * from t_car where brand like ?";
        String sql2 = "select * from t_car where brand like ? and putaway = 1";
        if (user.getAdminNo()==1){
            try {
                return findCarDao.findCarByBrand(sql1,brand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                return findCarDao.findCarByBrand(sql2,brand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> sortByPrice(int result,User user) {//排序
        String sql1 = "select * from t_car order by price asc";
        String sql2 = "select * from t_car order by price desc";
        String sql3 = "select * from t_car where putaway = 1 order by price asc";
        String sql4 = "select * from t_car where putaway = 1 order by price desc";
        if (result == 1){//降序
            if (user.getAdminNo()==1){//管理员
                try {
                    return findCarDao.sortByPrice(sql2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {//客户
                try {
                    return findCarDao.sortByPrice(sql4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {//升序
            if (user.getAdminNo()==1){//管理员
                try {
                    return findCarDao.sortByPrice(sql1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {//客户
                try {
                    return findCarDao.sortByPrice(sql3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<CarUser> findCarUser(User user) {//查询租车记录
        String sql1 = "select * from t_caruser where user_id != ?";
        String sql2 = "select * from t_caruser where user_id = ?";
        if (user.getAdminNo()==1){//管理员
            try {
                return findCarDao.findCarUser(sql1,0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {//客户
            try {
                return findCarDao.findCarUser(sql2,user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<CarUser> findCarUserByCarNo(int carNo) {//按汽车编号查询租赁记录
        try {
            return findCarDao.findCarUserByCarNo(carNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CarUser> findCarUserByUserNo(int userNo) {//按用户编号查询租赁记录
        try {
            return findCarDao.findCarUserByUserNo(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CarUser findCarUserById(int id) {//按记录编号查询汽车记录
        try {
            return findCarDao.findCarUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CarUser findCarUser() {//查询租赁记录最后一条,用于租车完成后展示给客户
        try {
            return findCarDao.findCarUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Brand> findBrand() {//查询品牌
        try {
            return findCarDao.findBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Type> findType() {//查询类型
        try {
            return findCarDao.findType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Brand findBrand(int id) {//按编号查询品牌
        try {
            return findCarDao.findBrand(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Type findType(int id) {//按编号查询类型
        try {
            return findCarDao.findType(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
