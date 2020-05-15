package com.security.inMemory.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by nitin on Wednesday, February/19/2020 at 11:13 PM
 */

@RestController
public class GreetingsController {

    @GetMapping("/inMemoryGreetings")
    public String InMemoryGreetings(Principal principal){
        return "Hello, " + principal.getName() + "!!";
    }

    @GetMapping("/")
    public String health(){
        return "Health is Good !!";
    }
}
