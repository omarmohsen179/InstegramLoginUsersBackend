package com.example.reactbackend.repositories;


import com.example.reactbackend.models.hashtag_post;
import com.example.reactbackend.models.likelinks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface likeResptiry  extends CrudRepository<likelinks,Long> {
  @Query(value="SELECT COUNT(likelinksid) FROM likelinks  where postid=?1 ",nativeQuery=true)
    Long amountoflikes(Long postid);
  @Query(value="INSERT INTO likelinks  (postid, userid) VALUES (?1,?2); ",nativeQuery=true)
  likelinks addpostlike(Long postid, Long hashtagid);
  @Query(value=" SELECT * FROM likelinks  where postid=?1 AND userid=?2  ",nativeQuery=true)
  likelinks checkuserlike(Long postid, Long hashtagid);
}
