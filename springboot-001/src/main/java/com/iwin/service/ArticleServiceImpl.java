package com.iwin.service;

import com.iwin.dao.ArticleJDBCDao;
import com.iwin.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-17 23:20
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleJDBCDao articleJDBCDao;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;
    @Override
    @Transactional
    public void saveArticle(Article article) {
        articleJDBCDao.save(article, primaryJdbcTemplate);
        articleJDBCDao.save(article, secondaryJdbcTemplate);
        int a = 10/0;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleJDBCDao.deleteById(id, null);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDao.updateById(article, null);
    }

    @Override
    public Article getArticle(Integer id) {
        return articleJDBCDao.findById(id, null);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDao.findAll( null);
    }
}
