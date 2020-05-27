package com.community.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.community.dto.AccessTokenDTO;
import com.community.dto.GithubUser;
import com.community.util.GithubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 用户授权github登陆后，github 回调此方法
 * @author: jnw
 * @time: 2020/5/27 4:10 下午
 */
@Controller
public class AuthorizeController {

    /**
     *
     * @description:  * 接受github授权登陆时的code与state
     * @return: index
     * @author: jnw
     * @time: 2020/5/27 4:13 下午
     */

    @Autowired
    private GithubUtil githubUtil;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();  //win+alt+v
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setClient_id("4a56179f97226c36f6f7");
        accessTokenDTO.setClient_secret("0b522e34794d80fc9094cc3581184ea0997b1ca6");
        accessTokenDTO.setState(state);
        String accessToken = githubUtil.getAccessToken(accessTokenDTO);
        GithubUser user = githubUtil.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
