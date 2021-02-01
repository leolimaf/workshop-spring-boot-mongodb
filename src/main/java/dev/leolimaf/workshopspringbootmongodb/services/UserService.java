package dev.leolimaf.workshopspringbootmongodb.services;

import dev.leolimaf.workshopspringbootmongodb.domain.User;
import dev.leolimaf.workshopspringbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

}
