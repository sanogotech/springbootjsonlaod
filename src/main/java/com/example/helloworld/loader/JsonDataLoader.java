package com.example.helloworld.loader;

import com.example.helloworld.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;

public class JsonDataLoader {

    public User loadUserData(String resourcePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource(resourcePath);
        User user = null;
        try {
            user = objectMapper.readValue(resource.getInputStream(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
