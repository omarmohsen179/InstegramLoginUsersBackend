package com.example.reactbackend.repositories;

import com.example.reactbackend.models.hashtag;
import com.example.reactbackend.models.hashtag_post;
import com.example.reactbackend.models.image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface hashtagResptiry  extends CrudRepository<hashtag,Long> {
    @Query(value="SELECT * FROM hashtag   where hashtagid  IN (SELECT hashtagid FROM hashtag_post where postid=?1 ) ",nativeQuery=true)
    List<hashtag> posthash(Long postid);
    @Query(value="INSERT INTO post_hashtag (postid, hashtagid) VALUES (?1,?2); ",nativeQuery=true)
    hashtag_post addposthashtag(Long postid,Long hashtagid);
    @Query(value="SELECT hashtagid,hashtag FROM hashtag where hashtag LIKE '%?1%' OR hashtag LIKE '?1%'  OR hashtag LIKE '%?1' ",nativeQuery=true)
    List<hashtag> searchhashtag(String hashtag);
    @Query(value="SELECT hashtagid,hashtag FROM user where hashtag =?1 ",nativeQuery=true)
    hashtag checkhashtag(String hashtag);
}
