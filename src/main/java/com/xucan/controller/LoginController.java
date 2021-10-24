package com.xucan.controller;

import com.xucan.domain.ResponseResult;
import com.xucan.domain.User;
import com.xucan.service.UserService;
import com.xucan.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Autowired
    private UserService userService;
    //    管理系统登录
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        User loginUser = userService.login(user);
        Map<String, Object> map;
        if (loginUser!=null){
            //如果正确 生成token返回
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getUid()), null);
            map.put("token", token);
        } else{
            //如果不正确 给出相应的提示
            return new ResponseResult(300, "用户名或密码错误，请重新登录");
        }
        return new ResponseResult(200, "登录成功", map);
    }
    //    小程序登录
    @RequestMapping("/loginMini")
    public String rtPostObject(@RequestParam String code){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx6a8c8858f424c528&secret=a95ded034e59ff27cee992493f12e833&js_code="+code+"&grant_type=authorization_code";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> response = restTemplate.getForEntity( url, String.class );
        System.out.println(response.getBody());
        return response.getBody();
    }
}
