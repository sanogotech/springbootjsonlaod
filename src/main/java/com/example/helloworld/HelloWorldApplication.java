package com.example.helloworld;

import com.example.helloworld.loader.JsonDataLoader;
import com.example.helloworld.model.User;
import com.example.helloworld.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        
        JsonDataLoader loader = new JsonDataLoader();
		
		//Pour Users
        List<User> users = loader.loadUserData("users.json");  // Assurez-vous que users.json est dans src/main/resources
        users.forEach(System.out::println);
		
		
		// Pour Persons
		List<Person> persons = loader.loadPersonData("persons.json");
        persons.forEach(System.out::println);
    }
}
