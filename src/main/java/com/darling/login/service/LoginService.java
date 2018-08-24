package com.darling.login.service;

import com.darling.login.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;


//    @HystrixCommand(fallbackMethod = "checkUserfallbackMethod")
    public User checkUser(String name,String pwd){
        String serviceId = "USERSERVER";
        User user = restTemplate.getForObject("http://"+serviceId+"/user/"+name,User.class);
        if(user != null) {
            if(pwd.equals(user.getPwd())) {
                return user;
            }
        }
        return null;
    }

    public User checkUserfallbackMethod(String name,String pwd) {
        System.out.println("进入容错方法");
        return new User();
    }

}
