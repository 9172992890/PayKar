package com.PayKar.transaction.resource;

import com.PayKar.transaction.Entity.User;
import com.PayKar.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ResourceController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public ResponseEntity<Object> getData(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        return new ResponseEntity<>("Hey "+name+" Welcome to my homepage......", HttpStatus.OK);
    }

    @GetMapping("/")
    public Optional<User> getData3(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        Optional<User> user=userService.getUserByUsername(username);
        if(user.isEmpty()){
            userService.createUser(User.builder().username(username).creationDate(System.currentTimeMillis()).build());
        }
        return userService.getUserByUsername(username);
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getData2(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        return new ResponseEntity<>("Hey "+name+" this is a test endpoint to get the resource data......", HttpStatus.OK);
    }
}
