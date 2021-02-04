package com.example.reactbackend.controll;


import com.example.reactbackend.models.*;
import com.example.reactbackend.services.serviceFunctionsname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//https://git.heroku.com/fullbackendapplication.git
@RequestMapping("/")
@CrossOrigin(origins = "*")
@RestController
public class contoller {
    @Autowired
    private serviceFunctionsname services;


    @GetMapping("/")
    public String getallperson() {
        return "my real app";
    }

    @GetMapping("/alluser")
    public List<user> getalluser(Model model) {

        return  (List<user>) services.findAllusers();
    }
    @GetMapping("/allpost")
    public List<post> getallposts(Model model) {
        return  (List<post>) services.findAllposts();
    }
    @GetMapping("/likes")
    public List<likelinks> getalllikes() {
        return  (List<likelinks>) services.findAlllikes();
    }
    @GetMapping("/userP")
    public user getuserwithposts() {
        Long idd=1L;
        return  (user) services.finduserwithposts(idd);
    }
    @GetMapping("/home")
    @ResponseBody
    public List<post> gethomeposts(@RequestParam Long id) {
       // http://localhost:8080/home?id=2

        return  (List<post>) services.homeposts(id);
    }
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public user login(@RequestBody user us) {
        return  (user) services.login(us.getUsername(),us.getPassword());
    }
    @GetMapping("/checkusername")
    @ResponseBody
    public user checkusername(@RequestParam String id) {

        user f=new user();
        if(services.usernamechecker(id)!=null)
        f.setUserid(services.usernamechecker(id).getUserid());
        return  f;
    }
      @GetMapping("/searchusername")
    @ResponseBody
    public List<user> searchusername(@RequestParam String id) {
        return  (List<user>) services.seachusername(id);
    }
   @GetMapping("/searchhashtag")
    @ResponseBody
    public List<hashtag> searchashtag(@RequestParam String id) {
        return  (List<hashtag>) services.seachhashtag(id);
    }

   @PostMapping("/insertuser")
    @ResponseStatus(HttpStatus.CREATED)
    public user insertuser(@RequestBody user us) {
        return  (user) services.insertuser(us);
    }
    @PostMapping("/updateuser")
    @ResponseStatus(HttpStatus.CREATED)
    public user updateuser(@RequestBody user us) {
        return  (user) services.updateuser(us);
    }
    @PostMapping("/insertpost")
    @ResponseStatus(HttpStatus.CREATED)
    public post insertpost(@RequestBody post us) {
        return  (post) services.insertpost(us);
    }
   @PostMapping("/updatepost")
    @ResponseStatus(HttpStatus.CREATED)
    public post updatepost(@RequestBody post us) {
        return  (post) services.updatepost(us);
    }
     @GetMapping("/albumposts")
    @ResponseBody
    public List<post> albumposts(@RequestParam Long id) {
        return  (List<post>) services.postplaylist(id);
    }
    @DeleteMapping("/deletepost")
    @ResponseBody
    public post deletepost(@RequestParam Long id) {
        return  (post) services.deleteposts(id);
    }
   @PostMapping("/insertalbum")
    @ResponseStatus(HttpStatus.CREATED)
    public album insertalbum(@RequestBody album us) {
        return  (album) services.insertplaylist(us);
    }
    @DeleteMapping("/deletealbum")
    @ResponseBody
    public  album deletealbum(@RequestParam Long id) {
        return  (album) services.deletalbum(id);
    }
    @PostMapping("/updatealbum")
    @ResponseStatus(HttpStatus.CREATED)
    public album updatealbum(@RequestBody album us) {
        return  (album) services.updatealbum(us);
    }
    @GetMapping("/useralbums")
    @ResponseBody
    public List<album> useralbums(@RequestParam Long id) {
        return  (List<album>) services.useralbums(id);
    }
    @PostMapping("/insertfollow")
    @ResponseStatus(HttpStatus.CREATED)
    public follows insertfoollow(@RequestBody follows us) {
        return   services.insertfollow(us);
    }
  @DeleteMapping("/deletefollow")
    @ResponseBody
    public  follows deletefollow(@RequestParam List<Long> id) {
        return  services.deletefollow(id.get(0),id.get(1));
    }
     @GetMapping("/checkfollowing")
    @ResponseBody
    public  follows checkfollowing(@RequestParam List<Long> id) {
        return  services.checkfollowing(id.get(0),id.get(1));
    }
    @GetMapping("/checkfollower")
    @ResponseBody
    public  follows checkfollower(@RequestParam List<Long> id) {
        return  services.checkfollower(id.get(0),id.get(1));
    }
    @PostMapping("/insertlike")
    @ResponseStatus(HttpStatus.CREATED)
    public likelinks insertlike(@RequestBody likelinks l) {
        return   services.insertlike(l);
    }
    @DeleteMapping("/deletelike")
    @ResponseBody
    public  likelinks deletelike(@RequestParam List<Long> id) {
        return  services.deletelike(id.get(0),id.get(1));
    }
    @PostMapping("/insertcomment")
    @ResponseStatus(HttpStatus.CREATED)
    public comment insertcomment(@RequestBody comment l) {
        return   services.insertcomment(l);
    }
    @DeleteMapping("/deletecomment")
    @ResponseBody
    public  comment deletecomment(@RequestParam Long id) {
        return  services.deletecomment(id);
    }
}
