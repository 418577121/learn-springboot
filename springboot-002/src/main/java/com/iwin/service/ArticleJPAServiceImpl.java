package com.iwin.service;

import com.iwin.dao.testdb.ArticleRepository;
import com.iwin.dao.testdb.Article;
import com.iwin.dao.testdb2.Message;
import com.iwin.dao.testdb2.MessageRepository;
import org.springframework.stereotype.Service;
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
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;
    @Override
    @Transactional
    public void saveArticle(Article article) {
        articleRepository.save(article);
        messageRepository.save(new Message(null, "dht", "aa"));
       // int a = 10/0;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article getArticle(Integer id) {
        Optional<Article> byId = articleRepository.findById(id);

        return (Article) byId.get();
    }

    @Override
    public List<Article> getAll() {

        return articleRepository.findAll();
    }
}
