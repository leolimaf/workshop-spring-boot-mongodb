package dev.leolimaf.workshopspringbootmongodb.services;

import dev.leolimaf.workshopspringbootmongodb.domain.Post;
import dev.leolimaf.workshopspringbootmongodb.repositories.PostRepository;
import dev.leolimaf.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

}
