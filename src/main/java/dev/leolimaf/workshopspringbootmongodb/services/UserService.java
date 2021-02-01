package dev.leolimaf.workshopspringbootmongodb.services;

import dev.leolimaf.workshopspringbootmongodb.domain.User;
import dev.leolimaf.workshopspringbootmongodb.repositories.UserRepository;
import dev.leolimaf.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

}
