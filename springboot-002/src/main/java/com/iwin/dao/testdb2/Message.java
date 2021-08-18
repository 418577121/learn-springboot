package com.iwin.dao.testdb2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.dao.testdb2
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-18 20:55
 **/

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

}
