package com.soft1841.list.week4;

import java.util.Date;

public class Article {

    private Integer id;
    private String title;
    private String author;
    private Date date;

    public Article(Integer id, String title, String author, Date writeTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = writeTime;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getWriteTime() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWriteTime(Date writeTime) {
        this.date = writeTime;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", " +
                "title='" + title + '\'' + "," +
                " author='" + author + '\'' + "," +
                " writeTime=" + date + '}';
    }
}
