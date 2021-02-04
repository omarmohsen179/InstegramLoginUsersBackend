package com.example.reactbackend.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postid;
    private Long userid;
    private String title;
    private String details;
    private Date postDate;
    private Long commentsamount;
    private Long likesamount;
    @OneToMany
    private List<comment> comments;



    @OneToMany
    private List<image>  images;
    @OneToMany
    private List<hashtag> hashtags;


    @ManyToOne
    private user userdata;

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Long getCommentsamount() {
        return commentsamount;
    }

    public void setCommentsamount(Long commentsamount) {
        this.commentsamount = commentsamount;
    }

    public Long getLikesamount() {
        return likesamount;
    }

    public void setLikesamount(Long likesamount) {
        this.likesamount = likesamount;
    }

    public List<comment> getComments() {
        return comments;
    }

    public void setComments(List<comment> comments) {
        this.comments = comments;
    }

    public List<image> getImages() {
        return images;
    }

    public void setImages(List<image> images) {
        this.images = images;
    }

    public List<hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public user getUserdata() {
        return userdata;
    }

    public void setUserdata(user userdata) {
        this.userdata = userdata;
    }
}
