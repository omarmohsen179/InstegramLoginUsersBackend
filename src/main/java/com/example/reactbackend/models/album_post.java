package com.example.reactbackend.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class album_post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int album_postid;
    private int albumid;
    private int postid;

    public int getAlbum_postid() {
        return album_postid;
    }

    public void setAlbum_postid(int album_postid) {
        this.album_postid = album_postid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }


}
