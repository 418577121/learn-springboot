package com.iwin.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.dao
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-18 12:24
 **/

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByAuthor(String author);
}
