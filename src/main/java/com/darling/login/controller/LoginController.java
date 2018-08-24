package com.darling.login.controller;


import com.darling.login.domain.User;
import com.darling.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;


    @GetMapping(value = "login/{name}/{pwd}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map getUser(@PathVariable("name") String name, @PathVariable("pwd") String pwd){
        Map map = new HashMap();
        User user = service.checkUser(name,pwd);
        if(user != null){
            if(pwd.equals(user.getPwd())){
                map.put("登录成功！",user);
                return map;
            }
        }
        map.put("登录失败！",user);
        return map;
    }
}
