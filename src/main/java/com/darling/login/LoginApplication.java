package com.darling.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@EnableFeignClients
//@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class LoginApplication {

//    @Bean
//    @LoadBalanced  // 表示使用负载均衡算法
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//    }

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}
