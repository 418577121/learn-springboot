package com.iwin.dao;

import com.iwin.entity.Article;
import io.swagger.models.auth.In;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.dao
 * @description: jdbc dao
 * @author: DingHaiTing
 * @create_time: 2021-08-17 22:48
 **/

@Repository
public class ArticleJDBCDao {
    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    public void save(Article article, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("insert into article(author, title, content, create_time) values (?,?,?,?)",
                article.getAuthor(), article.getTitle(), article.getContent(), article.getCreateTime());
    }

    public void deleteById(Integer id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("delete from article where id = ?", id);
    }

    public void updateById(Article article, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("update article set author = ? , title = ? , content = ? , create_time = ? where id = ?",
                article.getAuthor(), article.getTitle(), article.getContent(), article.getCreateTime(), article.getId());
    }

    public Article findById(Integer id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
     return    jdbcTemplate.queryForObject("select * from article where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class));
    }

    public List<Article> findAll( JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return (List<Article>) jdbcTemplate.query("select * from article", new BeanPropertyRowMapper<>(Article.class));
    }
}
