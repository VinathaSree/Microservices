package com.microservices.microservicesdemo.Controller;

import com.microservices.microservicesdemo.Model.User;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/")
    public String Hello(){
        return "Hello World";
    }
    //creating a end point
    @GetMapping("/user")
    public User getDetails(){
        User user = new User();
        user.setId(1);
        user.setEmail("vinatha.111@gmail.com");
        user.setName("vinatha sree");
        return user;
    }
    @GetMapping("/user/{id}/{id2}")
    public String getPathId(@PathVariable String id,@PathVariable("id2") String name){
        return "the id is" + id +"and"+ name;
    }
    @GetMapping("/requestparam")
    public String getRequestParam(@RequestParam String name,@RequestParam(required = false,defaultValue = "") String emailid){
        return "the name and email id is " + name + " " +emailid;
    }
}
