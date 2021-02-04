package com.example.reactbackend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class likelinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likelinksid;
    private Long userid;
    private Long postid;

    public Long getLikelinksid() {
        return likelinksid;
    }

    public void setLikelinksid(Long likelinksid) {
        this.likelinksid = likelinksid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }


}