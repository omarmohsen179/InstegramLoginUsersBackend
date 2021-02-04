package com.example.reactbackend.services;

import com.example.reactbackend.models.*;
import com.example.reactbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional


public class serviceFunctionsbody implements serviceFunctionsname{
    @Autowired
    private userResptiry userR;
    @Autowired
    private postResptiry postR;
   @Autowired
    private followResptiry followR;
    @Autowired
    private commentResptiry commentR;
    @Autowired
    private likeResptiry likeR;

    @Autowired
    private hashtagResptiry hashR;
    @Autowired
    private imageResptiry imageR;
    @Autowired
    private albumResptiry albumR;





    @Override
    public List<user> findAllusers() {

        return (List<user>) userR.findAll();
    }

    @Override
    public List<post> findAllposts() {
        return (List<post>) postR.findAll();
    }

    @Override
    public List<likelinks> findAlllikes() {
        return (List<likelinks>)likeR.findAll();
    }

    @Override
    public user finduserwithposts(Long id) {
        user d=userR.getuser(id);
        d.setPosts(postR.getuserpost(id));
        d.setFollowing(followR.useramountofollowing(id));
        d.setFollower(followR.useramountofollowers(id));
        List<follows> fol= followR.finduserfollower(id);
        d.setFollower((long) fol.size());
        return d;
    }

    @Override
    public List<post> homeposts(Long id) {
        List<post> posteslist= postR.homeposts(id);
      for(int i=0;i<posteslist.size();i++){
          user d=userR.getuser(id);
          posteslist.get(i).setUserdata(d);
            if(commentR.amountofcomments( posteslist.get(i).getPostid())!=null) {
                posteslist.get(i).setCommentsamount(commentR.amountofcomments(posteslist.get(i).getPostid()));
                posteslist.get(i).setComments(commentR.postcomment(posteslist.get(i).getPostid()));
            }
            else{
                posteslist.get(i).setCommentsamount(0L);
            }
            if(likeR.amountoflikes( posteslist.get(i).getPostid())!=null)
            posteslist.get(i).setLikesamount(likeR.amountoflikes( posteslist.get(i).getPostid()));
            else{
                posteslist.get(i).setLikesamount(0L);
            }
        if(hashR.posthash( posteslist.get(i).getPostid())!=null)
             posteslist.get(i).setHashtags(hashR.posthash( posteslist.get(i).getPostid()));
          else{
              posteslist.get(i).setLikesamount(0L);
          }
          if(hashR.posthash( posteslist.get(i).getPostid())!=null)
              posteslist.get(i).setHashtags(hashR.posthash( posteslist.get(i).getPostid()));
          else{
              posteslist.get(i).setLikesamount(0L);
          }
          if(imageR.postimages( posteslist.get(i).getPostid())!=null)
              posteslist.get(i).setImages(imageR.postimages( posteslist.get(i).getPostid()));


        }


        return posteslist;
    }

    @Override
    public user login(String username, String password) {
        return userR.login( username,password);
    }

    @Override
    public user usernamechecker(String usenmane) {
        return userR.checkusername(usenmane);
    }

    @Override
    public List<user> seachusername(String us) {
        return userR.seachusername(us);
    }

    @Override
    public List<hashtag> seachhashtag(String us) {
        return hashR.searchhashtag(us);
    }

    @Override
    public user insertuser(user us) {

        return userR.save(us);
    }

    @Override
    public user updateuser(user us) {

        return userR.save(us);
    }

    @Override
    public post insertpost(post us) {
        post my=postR.save(us);
        for(int i=0;i<us.getImages().size();i++){
            imageR.save(us.getImages().get(i));
        }
        for(int i=0;i<us.getHashtags().size();i++){
        if(hashR.checkhashtag(us.getHashtags().get(i).getHashtag())==null){
            hashR.save(us.getHashtags().get(i));
         }
        else{
            hashR.addposthashtag(my.getPostid(),us.getHashtags().get(i).getHashtagid());
        }
        }

        return my;
    }

    @Override
    public post updatepost(post us) {
        return postR.save(us);
    }

    @Override
    public List<post> postplaylist(Long playlist) {
        return postR.albumposts(playlist);
    }

    @Override
    public post deleteposts(Long postid) {
        post myin=new post();
        postR.deleteById(postid);
        myin.setPostid(-1L);
        return myin;
    }


    @Override
    public album insertplaylist(album f) {
        return albumR.save(f);
    }

    @Override
    public album deletalbum(Long id) {
        album myin=new album();
        albumR.deleteById(id);
        myin.setAlbumid(-1L);
        return myin;
    }

    @Override
    public album updatealbum(album f) {
        return albumR.save(f);
    }

    @Override
    public List<album> useralbums(Long userid) {
        return albumR.useralbums(userid);
    }

    @Override
    public follows insertfollow(follows f) {
        return followR.save(f);
    }

    @Override
    public follows deletefollow(Long u,Long f) {
        follows myin=new follows();
        if(followR.checkuserfollowing(u,f)!=null){
            followR.deleteById(followR.checkuserfollowing(u,f).getFollowingid());
            myin.setFollowingid(-1L);
            return myin;
        }
        else{
            myin.setFollowingid(-2L);
            return myin;
        }


    }

    @Override
    public follows checkfollowing(Long userid,Long fo) {
        return followR.checkuserfollowing(userid,fo);
    }

    @Override
    public follows checkfollower(Long userid,Long fo) {
        return followR.checkuserfollowing(userid,fo);
    }

    @Override
    public likelinks insertlike(likelinks l) {
        likelinks v=new likelinks();
        if(likeR.checkuserlike(l.getPostid(),l.getUserid())!=null){
            return likeR.save(l);
        }
        else{
            v.setLikelinksid(-1L);
            return v;
        }

    }

    @Override
    public likelinks deletelike(Long userid,Long postid) {
        likelinks v=new likelinks();
        if(likeR.checkuserlike(postid,userid)!=null){
            v.setLikelinksid(-2L);
            return v;
        }
        else{
            likeR.deleteById(likeR.checkuserlike(postid,userid).getLikelinksid());
            v.setLikelinksid(-1L);
            return v;
        }
    }

    @Override
    public comment insertcomment(comment l) {
        return commentR.save(l);
    }

    @Override
    public comment deletecomment(Long id) {
        comment myin=new comment();
       commentR.deleteById(id);
        myin.setCommentid(-1L);
        return myin;
    }

}
