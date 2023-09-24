package com.PayKar.transaction.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/home")
    public ResponseEntity<Object> getData(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        return new ResponseEntity<>("Hey "+name+" Welcome to my homepage......", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getData3(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        return new ResponseEntity<>("Hey "+name+" Welcome to my Redirected Page......", HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getData2(@AuthenticationPrincipal OAuth2User principal){
        String username=principal.getAttribute("login");
        String name = principal.getAttribute("name");
        String email=principal.getAttribute("email");
        return new ResponseEntity<>("Hey "+name+" this is a test endpoint to get the resource data......", HttpStatus.OK);
    }
}
