package com.example.reactbackend.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long albumid;
    private String name;
    private Long userid;

    public Long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Long albumid) {
        this.albumid = albumid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @OneToMany
    private List<post> posts;

    public List<post> getPosts() {
        return posts;
    }

    public void setPosts(List<post> posts) {
        this.posts = posts;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
