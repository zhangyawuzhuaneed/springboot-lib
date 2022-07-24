///*
//package com.example.controller;
//
//
//import com.example.service.impl.RedisServiceImpl;
//import jdk.nashorn.internal.runtime.JSONFunctions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import redis.clients.jedis.Jedis;
//
//import java.util.Iterator;
//import java.util.Set;
//
//@Controller
//public class RedisController {
//
//    @Autowired
//    private RedisServiceImpl redisService;
//
//
//    @RequestMapping("/redis1")
//    public Set index() {
//        System.out.println(redisService.index());
//        return redisService.index();
//    }
//
//
//    @RequestMapping("/redis2")
//    public String index1() {
//        Jedis jedis = new Jedis("localhost");
//        System.out.println(jedis);
//        System.out.println("server working" + jedis.ping());
//        Set<String> keys = jedis.keys("*");
//        Iterator<String> stringIterator = keys.iterator();
//        String key = stringIterator.next();
//        System.out.println(key);
////        while (stringIterator.hasNext()) {
////            key = stringIterator.next();
////            System.out.println(key);
////        }
//
////        jedis.close();
//        return key;
//    }
//}
//*/
