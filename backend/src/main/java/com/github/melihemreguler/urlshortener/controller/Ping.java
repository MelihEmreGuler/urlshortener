package com.github.melihemreguler.urlshortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Ping {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        System.out.println("ping");
        return ResponseEntity.ok("pong");
    }

}
