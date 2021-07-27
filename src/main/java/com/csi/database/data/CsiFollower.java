package com.csi.database.data;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 15:24
 * @Version 1.0.0
 */
public class CsiFollower {
   private Integer bloggerId;
   private Integer followerId;

    public Integer getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Integer bloggerId) {
        this.bloggerId = bloggerId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }
}
