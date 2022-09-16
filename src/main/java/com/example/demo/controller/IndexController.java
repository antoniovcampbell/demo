package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
=======
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
<<<<<<< HEAD
=======
    
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
    @GetMapping
    public ResponseEntity index(){
        return ResponseEntity.ok().body("Api Online");
    }
<<<<<<< HEAD
    @GetMapping("/index")
    public ResponseEntity index1(){
        return ResponseEntity.ok().body("Api Online");
    }
=======
>>>>>>> 24d517c8dcb94d5f2667ab1367dd27ed9f416b25
}
