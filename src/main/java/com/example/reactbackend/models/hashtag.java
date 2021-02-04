package com.example.reactbackend.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hashtagid;
    private String hashtag;
    @OneToMany
    private List<post> posts;

    public List<post> getPosts() {
        return posts;
    }

    public void setPosts(List<post> posts) {
        this.posts = posts;
    }

    public Long getHashtagid() {
        return hashtagid;
    }

    public void setHashtagid(Long hashtagid) {
        this.hashtagid = hashtagid;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }



}
