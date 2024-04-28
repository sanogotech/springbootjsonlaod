package com.example.helloworld.loader;

import com.example.helloworld.model.Person;
import com.example.helloworld.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;

public class JsonDataLoader {

    public List<User> loadUserData(String resourcePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource(resourcePath);
        List<User> users = null;
        try {
            users = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Person> loadPersonData(String resourcePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource(resourcePath);
        try {
            JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
            JsonNode personsNode = rootNode.path("persons");
            return objectMapper.convertValue(personsNode, new TypeReference<List<Person>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
