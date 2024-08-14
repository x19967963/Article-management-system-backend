package com.junhan.big_event.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.junhan.big_event.mapper.ArticleMapper;
import com.junhan.big_event.pojo.Article;
import com.junhan.big_event.pojo.PageBean;
import com.junhan.big_event.service.ArticleService;
import com.junhan.big_event.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        //補充屬性質
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = Integer.parseInt(map.get("id").toString());
        article.setCreateUser(userId);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1.創建PageBean物件，用來封裝查詢好的數據
        PageBean<Article> pageBean = new PageBean<>();
        //2.開啟分頁查詢(PageHelper)
        PageHelper.startPage(pageNum, pageSize);
        //3.調用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = Integer.parseInt(map.get("id").toString());
        List<Article> as =  articleMapper.list(userId, categoryId, state);
        //page中提供了方法，可以獲取PageHelper分頁查詢後得到的總紀錄條數，和當前頁數據
        Page<Article> p = (Page<Article>) as;
        //把數據填充進PageBean物件中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
