package com.itheima.dao;

import com.itheima.domain.Myuser;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.runners.Parameterized;

import java.util.List;
/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 在mybatis中针对,CRUD一共有四个注解
 *  @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     * 引入对象使用：property
     * 一个用户可以有多个账户，所以选择many = @Many
     * 用户和账户的联系是用户id，所以选择column = "id"
     * 一对多选择延迟加载，所以选择fetchType = FetchType.LAZY
     * @return
     * /*,
     *             @Result(property = "roles",column = "id",
     *                     many = @Many(select = "com.itheima.dao.IRoleDao.findRolesByUid",
     *                             fetchType = FetchType.LAZY))
     */

    @Select("select * from myuser")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY)),
            @Result(property = "roles",column = "id",
                                    many = @Many(select = "com.itheima.dao.IRoleDao.findRolesByUid",
                                             fetchType = FetchType.LAZY))
    })
    List<Myuser> findAll();
    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from myuser  where id=#{id} ")
    @ResultMap("userMap")
    Myuser findById(Integer userId);

    @Select("select * from myuser  where id=#{id} and username=#{username}")
    @ResultMap("userMap")
    Myuser findBynw(@Param("id")Integer id,@Param("username") String username);
    /*
    * 根据roleid查询用户信息
    * */
    @Select("select * from myuser where id in(select userid from user_role where roleid=#{rid})")
    @ResultMap("userMap")
    List<Myuser> findByRid(Integer rid);
    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    // @Select("select * from user where username like #{username} ")
    @Select("select * from myuser where username like '%${value}%' ")
    @ResultMap("userMap")
    List<Myuser> findUserByName(String username);


    /**
     * 查询总用户数量
     * @return
     *//*
    @Select("select count(*) from myuser ")
    int findTotalUser();

    *//**
     * 保存用户
     * @param user
     *//*
    @Insert("insert into myuser(username,address,sex)values(#{username},#{address},#{sex})")
    void saveUser(Myuser user);
    *//**
     * 更新用户
     * @param user
     *//*
    @Update("update myuser set username=#{username},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(Myuser user);

    *//**
     * 删除用户
     * @param userId
     *//*
    @Delete("delete from myuser where id=#{id} ")
    void deleteUser(Integer userId);*/



}
