package dev.leolimaf.workshopspringbootmongodb.resources;

import dev.leolimaf.workshopspringbootmongodb.domain.User;
import dev.leolimaf.workshopspringbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> fundAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
