package com.example.reactbackend.repositories;

import com.example.reactbackend.models.comment;
import com.example.reactbackend.models.image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface imageResptiry extends CrudRepository<image,Long> {
    @Query(value="SELECT * FROM image  where postid=?1 ",nativeQuery=true)
    List<image> postimages(Long postid);
}
