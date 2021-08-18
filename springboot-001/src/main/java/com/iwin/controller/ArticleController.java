package com.iwin.controller;

import com.iwin.common.AjaxResponse;
import com.iwin.entity.Article;
import com.iwin.service.ArticleService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Pipe;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.controller
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-17 23:23
 **/

@RestController
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Integer id) {
        Article article = articleService.getArticle(id);
        return AjaxResponse.success(article);
    }

    @PostMapping("article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        return AjaxResponse.success();
    }

    @GetMapping("/articles")
    public AjaxResponse getAll() {
        List<Article> all = articleService.getAll();
        return AjaxResponse.success(all);
    }

    @PutMapping("/article")
    public AjaxResponse update(@RequestBody Article article) {
        articleService.updateArticle(article);
        return AjaxResponse.success();
    }

}
