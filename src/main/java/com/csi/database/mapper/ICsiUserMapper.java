package com.csi.database.mapper;

import com.csi.database.data.CsiUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 15:26
 * @Version 1.0.0
 */
public interface ICsiUserMapper {
    /*
    查询所有用户数据
     */
    @Select("<script>"
            + "select * from user"
            +   "<where>"
            +     "<if test='userName!=null'>"
            +        "user_name like '%${userName}%'"
            +     "</if>"
            +   "</where>"
            + "</script>")
    public List<CsiUser> queryAllUser(String userName) throws Exception;

    /**
     * 条件查询，登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Select("select * from user where user_name=#{userName} " + "and user_password=#{password}")
    public CsiUser queryByLogin(@Param("userName") String userName,
                                  @Param("password") String password) throws Exception;

    /**
     * 条件查询，根据ID查找用户
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from user where user_id=#{id}")
    public CsiUser queryByIdUser(Integer id) throws Exception;

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    @Insert("insert into user(user_name, user_password, user_birthday, user_face, user_mail, user_create_date)"
            + " values(#{userName},#{userPassword},#{userGender},#{userBirthday},#{userFace},#{userMail},#{userCreateDate})")
    public void addUser(CsiUser user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    @Update("update user set user_name=#{userName},user_password=#{userPassword},"
            + "user_birthday=#{userBirthday}," +
            "user_face=#{userFace},user_mail=#{userMail},user_create_date=#{userCreateDate} " +
            "where user_id=#{userId}")
    public void updateUser(CsiUser user) throws Exception;

    /**
     * 删除用户
     * @param ids
     * @throws Exception
     */
    @Delete("delete from user where user_id in(${ids})")
    public void deleteUser(String ids) throws Exception;
}
