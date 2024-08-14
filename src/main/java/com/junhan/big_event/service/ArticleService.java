package com.junhan.big_event.service;

import com.junhan.big_event.pojo.Article;
import com.junhan.big_event.pojo.PageBean;

public interface ArticleService {
    //新增文章
    void add(Article article);
    //條件分頁列表查詢
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
    //查詢文章
    Article findById(Integer id);
    //更新文章
    void update(Article article);
    //刪除文章
    void delete(Integer id);
}
