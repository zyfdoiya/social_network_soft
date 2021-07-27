package com.csi.database.data;

import java.sql.Date;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 15:21
 * @Version 1.0.0
 */
public class CsiComment {
    private Integer commentId;
    private String commentContent;
    private Date commentDate;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
