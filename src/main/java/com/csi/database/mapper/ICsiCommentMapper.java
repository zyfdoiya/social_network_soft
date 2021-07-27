package com.csi.database.mapper;

import com.csi.database.data.CsiComment;
import com.csi.database.data.CsiEssay;
import com.csi.database.data.CsiUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 16:08
 * @Version 1.0.0
 */
public interface ICsiCommentMapper {
    /*
    查询所有评论
     */
    @Select("<script>"
            + "select * from comment"
            +   "<where>"
            +     "<if test='commentContent!=null'>"
            +        "comment_content like '%${commentContent}%'"
            +     "</if>"
            +   "</where>"
            + "</script>")
    public List<CsiComment> queryAllComment(String commentContent) throws Exception;

    /**
     * 条件查询，根据ID查找评论
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from comment where comment_id=#{id}")
    public CsiComment queryByIdComment(Integer id) throws Exception;

    /**
     * 添加评论
     * @param comment
     * @throws Exception
     */
    @Insert("insert into comment(comment_id, comment_content, comment_date)"
            + " values(#{commentId},#{commentContent},#{commentDate})")
    public void addComment(CsiComment comment) throws Exception;

    /**
     * 修改评论
     * @param comment
     * @throws Exception
     */
    @Update("update comment set comment_content=#{commentContent},comment_date=#{commentDate},"
            + "where comment_id=#{commentId}")
    public void updateComment(CsiComment comment) throws Exception;

    /**
     * 删除评论
     * @param ids
     * @throws Exception
     */
    @Delete("delete from comment where comment_id in(${ids})")
    public void deleteComment(String ids) throws Exception;
}
