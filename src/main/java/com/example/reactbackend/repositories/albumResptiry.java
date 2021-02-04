package com.example.reactbackend.repositories;

import com.example.reactbackend.models.album;
import com.example.reactbackend.models.follows;
import com.example.reactbackend.models.hashtag_post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface albumResptiry extends CrudRepository<album,Long> {
    @Query(value="SELECT * FROM albums where userid=?1 " ,nativeQuery=true)
    List<album> useralbums(Long userid);
    @Query(value="SELECT * FROM post where albumid=?1 " ,nativeQuery=true)
    List<album> albumposts(Long userid);
    @Query(value="INSERT INTO album_post (postid, albumid) VALUES (?1,?2); ",nativeQuery=true)
    List<hashtag_post> addpostalbum(Long postid, Long hashtagid);
}
