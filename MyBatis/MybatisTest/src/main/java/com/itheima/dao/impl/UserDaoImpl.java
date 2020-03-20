package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.Myuser;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<Myuser> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<Myuser> users = session.selectList("com.itheima.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(Myuser user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.insert("com.itheima.dao.IUserDao.saveUser",user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    public void updateUser(Myuser user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.update("com.itheima.dao.IUserDao.updateUser",user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    public void deleteUser(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.delete("com.itheima.dao.IUserDao.deleteUser",userId);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    public Myuser findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        Myuser user = session.selectOne("com.itheima.dao.IUserDao.findById",userId);
        //3.释放资源
        session.close();
        return user;
    }

    public List<Myuser> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<Myuser> users = session.selectList("com.itheima.dao.IUserDao.findByName",username);
        //3.释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        Integer count = session.selectOne("com.itheima.dao.IUserDao.findTotal");
        //3.释放资源
        session.close();
        return count;
    }

    public List<Myuser> findUserByCondition(Myuser user) {
        return null;
    }

    public List<Myuser> findUserInIds(QueryVo vo) {
        return null;
    }

    public void updateUser(User user) {

    }
}
