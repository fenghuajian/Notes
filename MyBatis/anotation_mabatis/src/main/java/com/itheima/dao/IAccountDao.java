package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
//import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {
    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * 一个账户对应一个用户：所以选择one=@One
     * 一对一选择立即加载：所以选择fetchType= FetchType.EAGER
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "userid",property = "userid"),
            @Result(column = "money",property = "money"),
            @Result(property = "myuser",column = "userid",one=@One(select="com.itheima.dao.IUserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();
    /**
     * 根据用户id查询账户信息
     */
    @Select("select * from account where userid = #{userid}")
    List<Account> findAccountByUid(Integer uid);
    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    //List<AccountUser> findAllAccount();
}
