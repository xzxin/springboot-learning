package com.xzx.springbootdemo.entity;

public class BlogMeta {
    Integer blogId;
    String blogName;
    Integer blogAuthorId;
    String blogCreateDate;
    String blogLastModifyDate;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public Integer getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(Integer blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public String getBlogCreateDate() {
        return blogCreateDate;
    }

    public void setBlogCreateDate(String createData) {
        this.blogCreateDate = createData;
    }

    public String getBlogLastModifyDate() {
        return blogLastModifyDate;
    }

    public void setBlogLastModifyDate(String blogLastModifyDate) {
        this.blogLastModifyDate = blogLastModifyDate;
    }
}
