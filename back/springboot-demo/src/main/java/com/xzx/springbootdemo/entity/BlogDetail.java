package com.xzx.springbootdemo.entity;

public class BlogDetail {
    private Integer blogId;
    private String blogComments;
    private Integer thumbsUp;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(String blogComments) {
        this.blogComments = blogComments;
    }

    public Integer getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Integer thumbsUp) {
        this.thumbsUp = thumbsUp;
    }
}
