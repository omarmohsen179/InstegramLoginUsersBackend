package com.example.reactbackend.models;

import javax.persistence.*;
import java.util.Date;

@Entity

public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentid;
    private String comment;
    private Date commentDate;
    private Long postid;
    private Long userid;
   @ManyToOne
    private user usercomment;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
