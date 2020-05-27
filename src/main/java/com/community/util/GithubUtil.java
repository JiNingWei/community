package com.community.util;

import com.alibaba.fastjson.JSON;
import com.community.dto.AccessTokenDTO;
import com.community.dto.GithubUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;

/**
 * @description:
 * @author: jnw
 * @time: 2020/5/27 4:18 下午
 */
@Component
public class GithubUtil {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();


            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://api.github.com/user?access_token=" + accessToken)
            .build();

        try {
           Response response = client.newCall(request).execute();
           String string =  response.body().string();
           GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
           return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
           return null;

    }
}
