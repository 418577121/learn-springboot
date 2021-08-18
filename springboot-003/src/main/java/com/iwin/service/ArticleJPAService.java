package com.iwin.service;

import com.iwin.entity.Article;

import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-18 12:27
 **/

public interface ArticleJPAService {
    public void saveArticle(Article article);
    public void deleteArticle(Integer id);
    public void updateArticle(Article article);
    public Article getArticle(Integer id);
    public List<Article> getAll();
}
