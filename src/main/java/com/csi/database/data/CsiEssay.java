package com.csi.database.data;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 15:19
 * @Version 1.0.0
 */
public class CsiEssay {
    private String title;
    private String essayContentPath;
    private Integer essayId;
    private Integer clickCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEssayContentPath() {
        return essayContentPath;
    }

    public void setEssayContentPath(String essayContentPath) {
        this.essayContentPath = essayContentPath;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }
}
