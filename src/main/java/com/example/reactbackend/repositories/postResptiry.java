package com.example.reactbackend.repositories;

import com.example.reactbackend.models.post;
import com.example.reactbackend.models.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.reactbackend.models.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface postResptiry extends CrudRepository<post,Long>{
    @Query(value="SELECT u.* FROM post u where u.userid=?1 ",nativeQuery=true)
    List<post> getuserpost(Long userid);
     @Query(value="SELECT * FROM post where userid IN (SELECT following FROM follows where follower=?1 ) OR userid=?1 ORDER BY postid DESC limit 10",nativeQuery=true)
     List<post> homeposts(Long id);

    @Query(value="SELECT * FROM post where postid IN (SELECT postid FROM album_post where albumid=?1 )",nativeQuery=true)
    List<post> albumposts(Long id);



}
