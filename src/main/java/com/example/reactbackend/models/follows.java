package com.example.reactbackend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class follows {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long followingid;
    private Long follower;
    private Long following;

    public Long getFollowingid() {
        return followingid;
    }

    public void setFollowingid(Long followingid) {
        this.followingid = followingid;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }
}
