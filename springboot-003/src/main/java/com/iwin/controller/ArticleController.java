package com.iwin.controller;



import com.iwin.common.AjaxResponse;
import com.iwin.entity.Article;
import com.iwin.service.ArticleJPAService;
import com.iwin.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    private ArticleJPAService articleService;

    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Integer id) {

        if (id == 1) {
            exceptionService.systemBizError();
        } else {
            exceptionService.userBizError(-1);
        }
        Article article = articleService.getArticle(id);
        return AjaxResponse.success(article);
    }

    @PostMapping("/article")
    public AjaxResponse saveArticle(@Valid @RequestBody Article article) {
        articleService.saveArticle(article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        return AjaxResponse.success();
    }

    @GetMapping("/articles")
    public List<Article> getAll() {
        List<Article> all = articleService.getAll();
        return all;
    }

    @PutMapping("/article")
    public AjaxResponse update(@RequestBody Article article) {
        articleService.updateArticle(article);
        return AjaxResponse.success();
    }

}
