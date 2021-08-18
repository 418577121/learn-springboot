package com.iwin.service;


import com.iwin.entity.Article;
import com.iwin.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-18 12:27
 **/

@Service
public class ArticleJPAServiceImpl implements ArticleJPAService {

    @Resource
    private ArticleMapper articleMapper;
    @Override
    @Transactional
    public void saveArticle(Article article) {
        articleMapper.insert(article);
        deleteArticle(3);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteArticle(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateById(article);
    }

    @Override
    public Article getArticle(Integer id) {
        Article article = articleMapper.selectById(id);

        return article;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = articleMapper.selectList(null);
        return articles;
    }
}
