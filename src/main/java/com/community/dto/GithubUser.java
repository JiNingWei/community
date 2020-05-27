package com.community.dto;

/**
 * @description:
 * @author: jnw
 * @time: 2020/5/27 4:55 下午
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    //win+n 生成get/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
