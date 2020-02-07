package com.example.demo.controller;


import com.example.demo.pojo.OauthClientDetails;
import com.example.demo.service.OauthClientDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2020-02-06
 */
@RestController
@RequestMapping("/oauthClientDetails")
public class OauthClientDetailsController {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private OauthClientDetailsService oauthClientDetailsService;

    @RequestMapping("/add")
    public OauthClientDetails add(){
        OauthClientDetails oauthClientDetails=new OauthClientDetails();

        oauthClientDetails.setClientId("user");
        oauthClientDetails.setClientSecret(passwordEncoder.encode("123456"));
        oauthClientDetails.setAccessTokenValidity(3000);
        oauthClientDetails.setRefreshTokenValidity(3000);
        oauthClientDetails.setAuthorizedGrantTypes("authorization_code,refresh_token");
        oauthClientDetails.setWebServerRedirectUri("http://localhost:8082/redirect");
        oauthClientDetails.setScope("user");

        oauthClientDetailsService.save(oauthClientDetails);
        return oauthClientDetails;
    }
}

