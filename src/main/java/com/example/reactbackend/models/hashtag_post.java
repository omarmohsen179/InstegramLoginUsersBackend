package com.example.reactbackend.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class hashtag_post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long  post_hashtagid;
    private Long hashtagid;
    private Long postid;

    public Long getPost_hashtagid() {
        return post_hashtagid;
    }

    public void setPost_hashtagid(Long post_hashtagid) {
        this.post_hashtagid = post_hashtagid;
    }

    public Long getHashtagid() {
        return hashtagid;
    }

    public void setHashtagid(Long hashtagid) {
        this.hashtagid = hashtagid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

}
