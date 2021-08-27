package com.iwn;

import com.iwn.entity.Address;
import com.iwn.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = SpringbootRedisApplication.class)
public class RedisConfigTest2 {

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;   //以redis string类型存取Java Object(序列化反序列化)

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations; //以redis的hash类型存储java Object

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations; //以redis的list类型存储java Object

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;   //以redis的set类型存储java Object

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;  //以redis的zset类型存储java Object


    @Test
    public void testValueObj() {
        Person person = new Person("boke","byrant");
        person.setAddress(new Address("南京","中国"));
        //向redis数据库保存数据(key,value),数据有效期20秒
        valueOperations.set("player:1",person,20, TimeUnit.SECONDS); //20秒之后数据消失
        //根据key把数据取出来
        Person getBack = (Person)valueOperations.get("player:1");
        System.out.println(getBack);
    }

    @Test
    public void testSetOperation() {
        Person person = new Person("kobe","byrant");
        Person person2 = new Person("curry","stephen");

        setOperations.add("playerset",person,person2);  //向Set中添加数据项
        //members获取Redis Set中的所有记录
        Set<Object> result = setOperations.members("playerset");
        System.out.println(result);  //包含kobe和curry的数组
    }

    @Test
    public void HashOperations() {
        Person person = new Person("kobe","byrant");
        //使用hash的方法存储对象数据（一个属性一个属性的存，下节教大家简单的方法）
        hashOperations.put("hash:player","firstname",person.getFirstname());
        hashOperations.put("hash:player","lastname",person.getLastname());
        hashOperations.put("hash:player","address",person.getAddress());
        //取出一个对象的属性值，有没有办法一次将整个对象取出来？有，下节介绍
        String firstName = (String)hashOperations.get("hash:player","firstname");
        System.out.println(firstName);   //kobe
    }

    @Test
    public void  ListOperations() {
        //将数据对象放入队列
        listOperations.leftPush("list:player",new Person("kobe","byrant"));
        listOperations.leftPush("list:player",new Person("Jordan","Mikel"));
        listOperations.leftPush("list:player",new Person("curry","stephen"));
        //从左侧存，再从左侧取，所以取出来的数据是后放入的curry
        Person person = (Person) listOperations.leftPop("list:player");
        System.out.println(person); //curry对象
    }
}