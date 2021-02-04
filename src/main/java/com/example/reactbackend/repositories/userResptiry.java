package com.example.reactbackend.repositories;


import com.example.reactbackend.models.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userResptiry extends CrudRepository<user,Long>{
   @Query(value="SELECT username FROM user where username=?1",nativeQuery=true)
    user checkusername(String username);
    @Query(value="SELECT * FROM user where username=?1 AND password=?2",nativeQuery=true)
    user login(String username,String password);

    @Query(value="SELECT u.* FROM user u  where u.userid=?1 ",nativeQuery=true)
    user getuser(Long userid);

    @Query(value="SELECT username, imageurl FROM user where username LIKE '%?1%' OR username LIKE '?1%'  OR username LIKE '%?1'",nativeQuery=true)
    List<user>  seachusername(String us);
}
