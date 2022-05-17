package com.xuecheng.manage_cms;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 2020 -06 -12
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms")
@ComponentScan(basePackages={"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages={"com.xuecheng.manage_cms"})
@ComponentScan(basePackages="com.xuecheng.framework")//扫描common工程下的类
public class ManageCmsApplication {
    public static void main(String[] args) {
        //SpringApplication.run(ManageCmsApplication.class,args);
        SpringApplication.run(ManageCmsApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


//    @Value("${spring.data.mongodb.database}")
//    String db;
//
//    @Bean
//    public GridFSBucket getGridFSBucket(MongoClient mongoClient){
//        MongoDatabase database = mongoClient.getDatabase(db);
//        GridFSBucket bucket = GridFSBuckets.create(database);
//        return bucket;
//    }
}
