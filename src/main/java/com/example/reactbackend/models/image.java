package com.example.reactbackend.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
@Entity
public class image{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageid;
    private Long postid;
    private String imageurl;

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    private Blob image;

}
