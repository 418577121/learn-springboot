package com.iwin.service;

import com.iwin.entity.Article;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description: Article Service
 * @author: DingHaiTing
 * @create_time: 2021-08-17 23:17
 **/

public interface ArticleService {
    public void saveArticle(Article article);
    public void deleteArticle(Integer id);
    public void updateArticle(Article article);
    public Article getArticle(Integer id);
    public List<Article> getAll();
}
