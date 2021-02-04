package com.example.reactbackend.services;

import com.example.reactbackend.models.*;

import java.util.List;

public interface serviceFunctionsname {
    List<user> findAllusers();
    List<post> findAllposts();
    List<likelinks> findAlllikes();
   user finduserwithposts(Long id);
   List<post> homeposts(Long userid);
   user login(String username,String password);
   user usernamechecker(String usenmane);
    List<user>  seachusername(String us);
    List<hashtag>  seachhashtag(String us);
    user insertuser(user us);
    user updateuser(user us);
    post insertpost(post us);
    post updatepost(post us);
    List<post> postplaylist(Long playlist);
    post deleteposts(Long postid);
    album insertplaylist(album f);
    album deletalbum(Long id);
    album updatealbum(album f);
    List<album> useralbums(Long userid);
    follows insertfollow(follows f);
    follows deletefollow(Long u,Long f);
    follows checkfollowing(Long userid,Long f);
    follows checkfollower(Long userid,Long f);
    likelinks insertlike(likelinks l);
    likelinks deletelike(Long userid,Long f);
    comment insertcomment(comment l);
    comment deletecomment(Long id);



}
