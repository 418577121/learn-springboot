package com.iwn;

import com.iwn.entity.Address;
import com.iwn.entity.ArticleVO;
import com.iwn.entity.Person;
import com.iwn.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = SpringbootRedisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootRedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;   //以String序列化方式保存数据的通用模板类

    @Resource
    private RedisTemplate<String, Person> redisTemplate;   //默认以JDK二进制方式保存数据的通用模板类

    @Test
    public void stringRedisTemplate() {
        Person person = new Person("kobe","byrant");
        person.setAddress(new Address("洛杉矶","美国"));
        stringRedisTemplate.opsForValue().set("k1", "v2");
        //将数据存入redis数据库
        stringRedisTemplate.opsForValue().set("player:srt","kobe byrant",20, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("player:rt",person,20, TimeUnit.SECONDS);
    }

    @Resource
    MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("2444718120@qq.com",
                "测试邮件",
                "测试邮件---测试......................");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail("1071959936@qq.com","别乱点","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                +"      <h3>\"一封html测试邮件\"</h3>\n"
                +"      <span>http://www.kk44kk.com</span>"
                + "     <div style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://236zz.com\" target=\"_bank\" >"
                + "           <strong>希望你有所收获</strong></a></div>\n"
                + " </div>\n" + "</body>");
    }


    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    public void sendTemplateMail() throws IOException, TemplateException, MessagingException {
        //添加动态数据，替换模板里面的占位符
        List<ArticleVO> articles = new ArrayList<>();
        articles.add(new ArticleVO(1L,"zimug","手摸手教你学spring boot","内容一",new Date(),null));
        articles.add(new ArticleVO(2L,"zimug","手摸手教你学spring boot","内容二",new Date(),null));
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("freemarker-temp.html");
        //将模板文件及数据渲染完成之后，转换为html字符串
        Map<String,Object> model = new HashMap<>();
        model.put("articles",articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);

        //发送邮件
        mailService.sendHtmlMail("418577121@qq.com","一封freemarker模板的html测试邮件",templateHtml);
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "D:\\images\\111.png";
        mailService.sendAttachmentsMail("2444718120@qq.com",
                "这是一封带附件的邮件", "邮件中有附件，请注意查收！",
                filePath);
    }

    @Test
    public void sendResourceMail() throws MessagingException {
        String rscId = "iwin";
        String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath =  "D:\\images\\test.png";
        mailService.sendResourceMail("4@qq.com",
                "这邮件中含有图片",
                content,
                imgPath,
                rscId);

    }
}
