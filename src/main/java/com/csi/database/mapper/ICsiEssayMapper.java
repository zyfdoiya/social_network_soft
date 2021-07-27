package com.csi.database.mapper;

import com.csi.database.data.CsiEssay;
import com.csi.database.data.CsiUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 15:48
 * @Version 1.0.0
 */
public interface ICsiEssayMapper {
    /*
    查询所有文章数据
     */
    @Select("<script>"
            + "select * from essay"
            +   "<where>"
            +     "<if test='title!=null'>"
            +        "title like '%${title}%'"
            +     "</if>"
            +   "</where>"
            + "</script>")
    public List<CsiEssay> queryAllEssay(String title) throws Exception;

    /**
     * 条件查询，根据ID查找文章
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from essay where essay_id=#{id}")
    public CsiEssay queryByIdEssay(Integer id) throws Exception;

    /**
     * 添加文章
     * @param essay
     * @throws Exception
     */
    @Insert("insert into essay(title, essay_content_path, essay_id, click_count)"
            + " values(#{title},#{essayContentPath},#{essayId},#{clickCount})")
    public void addEssay(CsiEssay essay) throws Exception;

    /**
     * 修改文章
     * @param essay
     * @throws Exception
     */
    @Update("update essay set title=#{title},essay_content_path=#{essayContentPath},"
            + "click_count=#{clickCount}," +
            "where essay_id=#{essayId}")
    public void updateEssay(CsiEssay essay) throws Exception;

    /**
     * 删除文章
     * @param ids
     * @throws Exception
     */
    @Delete("delete from essay where essay_id in(${ids})")
    public void deleteEssay(String ids) throws Exception;
}
