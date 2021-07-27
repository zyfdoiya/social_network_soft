package com.csi.database.mapper;

import com.csi.database.data.CsiComment;
import com.csi.database.data.CsiFollower;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 16:21
 * @Version 1.0.0
 */
public interface ICsiFollower {
    /*
        查询所有粉丝
     */
    @Select("<script>"
            + "select * from follower"
            +   "<where>"
            +     "<if follower_id='followerId!=null'>"
            +        "follower_id like '%${followerId}%'"
            +     "</if>"
            +   "</where>"
            + "</script>")
    public List<CsiFollower> queryAllFollower(String followerId) throws Exception;

    /**
     * 条件查询，根据ID查找粉丝
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from follower where follower_id=#{id}")
    public CsiFollower queryByIdFollower(Integer id) throws Exception;

    /**
     * 添加粉丝
     * @param follower
     * @throws Exception
     */
    @Insert("insert into follower(blogger_id, follower_id)"
            + " values(#{bloggerId},#{followerId})")
    public void addFollower(CsiFollower follower) throws Exception;

    /**
     * 修改粉丝信息
     * @param follower
     * @throws Exception
     */
    @Update("update follower set follower_id=#{followerId}"
            + "where blogger_id=#{bloggerId}")
    public void updateFollower(CsiFollower follower) throws Exception;

    /**
     * 删除粉丝
     * @param ids
     * @throws Exception
     */
    @Delete("delete from follower where follower_id in(${ids})")
    public void deleteFollower(String ids) throws Exception;
}
