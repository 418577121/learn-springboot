package com.iwin.dao.testdb2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.dao.testdb2
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-18 20:55
 **/

public interface MessageRepository extends JpaRepository<Message,Long> {

}
