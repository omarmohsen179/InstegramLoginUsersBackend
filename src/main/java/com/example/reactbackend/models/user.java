package com.example.reactbackend.models;

import javax.persistence.*;
import java.util.List;

@Entity

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    private String username;
    private String email;
    private String password;
    private String name;
    private String bio;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String imageurl;

    @OneToMany
    private List<post> posts;
    @OneToMany
    private List<album> albums;

    public List<album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<album> albums) {
        this.albums = albums;
    }
/*
    /* @OneToMany
            private List<chat> userchats;*/


    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }




    public List<post> getPosts() {
        return posts;
    }

    public void setPosts(List<post> posts) {
        this.posts = posts;
    }

    private Long following;
    private Long follower;

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }




    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
