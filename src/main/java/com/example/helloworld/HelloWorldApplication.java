package com.example.helloworld;

import com.example.helloworld.loader.JsonDataLoader;
import com.example.helloworld.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        
        JsonDataLoader loader = new JsonDataLoader();
        User user = loader.loadUserData("users.json");  // Assurez-vous que user.json est dans src/main/resources
        System.out.println(user);
    }
}
