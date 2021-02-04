package com.example.reactbackend.repositories;

import com.example.reactbackend.models.follows;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface followResptiry extends CrudRepository<follows,Long> {
    @Query(value="SELECT * FROM follows where follower=?1 " ,nativeQuery=true)
    List<follows> finduserfollowing(Long userid);

    @Query(value="SELECT * FROM follows where following=?1 " ,nativeQuery=true)
    List<follows> finduserfollower(Long userid);

    @Query(value="SELECT COUNT(followingid) FROM follows  where following=?1 " ,nativeQuery=true)
    Long useramountofollowers(Long userid);
    @Query(value="SELECT COUNT(followingid) FROM follows  where follower=?1 " ,nativeQuery=true)
    Long useramountofollowing(Long userid);
    @Query(value="SELECT * FROM follows  where follower=?1 AND following=?2 " ,nativeQuery=true)
    follows checkuserfollowing(Long userid,Long ds);
    @Query(value="SELECT * FROM follows  where following=?1 AND follower=?2 " ,nativeQuery=true)
    follows checkuserfollower(Long userid,Long ds);
}
