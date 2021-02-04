package com.example.reactbackend.repositories;


import com.example.reactbackend.models.comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentResptiry extends CrudRepository<comment,Long> {

    @Query(value="SELECT COUNT(commentid) FROM comment  where postid=?1 ",nativeQuery=true)
    Long amountofcomments(Long postid);
    @Query(value="SELECT * FROM comment  where postid=?1 ",nativeQuery=true)
    List<comment> postcomment(Long postid);
}
