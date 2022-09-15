package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 6615d948c2448eeb15ee94a24e18ba07728e1e88
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
<<<<<<< HEAD
    
=======
>>>>>>> 6615d948c2448eeb15ee94a24e18ba07728e1e88
    @GetMapping
    public ResponseEntity index(){
        return ResponseEntity.ok().body("Api Online");
    }
<<<<<<< HEAD
=======
    @GetMapping("/index")
    public ResponseEntity index1(){
        return ResponseEntity.ok().body("Api Online");
    }
>>>>>>> 6615d948c2448eeb15ee94a24e18ba07728e1e88
}
