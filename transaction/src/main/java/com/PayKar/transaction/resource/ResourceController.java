package com.PayKar.transaction.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/home")
    public ResponseEntity<Object> getData(){
        return new ResponseEntity<>("Welcome to my homepage......", HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getData2(){
        return new ResponseEntity<>("this is a test endpoint to get the resource data......", HttpStatus.OK);
    }
}
