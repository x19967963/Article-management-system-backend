package com.junhan.big_event.service;

import com.junhan.big_event.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增分類
    void add(Category category);
    //列表查詢
    List<Category> list();
    //根據id查詢分類訊息
    Category findById(Integer id);
    //更新分類
    void update(Category category);
    //根據id刪除分類
    void delete(Integer id);
}
