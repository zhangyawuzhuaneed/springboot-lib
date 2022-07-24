package com.example;

import com.example.pojo.User;
//import com.example.service.impl.RedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
//import com.example.config.RedisConfig;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Mybatis05SpringbootApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    private JedisPool jedisPool;
//
//    @Autowired
//    private RedisServiceImpl redisService;
//
//    @Test
//    void contextLoads4() {
//
//        System.out.println(redisService.index());
//    }


    @Test
    void contextLoads3() {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis);
        System.out.println("server working" + jedis.ping());
        Set<String> keys = jedis.keys("*");
        Iterator<String> stringIterator = keys.iterator();
        while (stringIterator.hasNext()) {
            String key = stringIterator.next();
            System.out.println(key);
        }
        jedis.close();
    }


    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }


    @Test
    void contextLoads1() {

//        User user = new User(); ctrl+shift+space
        User user = new User();
        redisTemplate.opsForValue().set("k2", "v2");
//        redisTemplate.opsForValue().get("k1");
        System.out.println(redisTemplate.opsForValue().get("k2"));
        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("name1", "风清扬1");
        String name = vo.get("name1").toString();
        System.out.println("name1" + name);
        redisTemplate.expire("name1", 10, TimeUnit.SECONDS);
    }

    @Test
    void contextLoads2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("11");
        list.add("12");
        list.add("121");
        list.add("122");
        list.add("123");
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", list);
        List<String> redislist = (List<String>) listOperations.leftPop("list");
        System.out.println(redislist);
        redisTemplate.expire("list", 60, TimeUnit.SECONDS);
    }

}
