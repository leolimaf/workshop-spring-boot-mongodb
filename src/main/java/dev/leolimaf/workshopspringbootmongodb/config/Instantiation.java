package dev.leolimaf.workshopspringbootmongodb.config;

import dev.leolimaf.workshopspringbootmongodb.domain.Post;
import dev.leolimaf.workshopspringbootmongodb.domain.User;
import dev.leolimaf.workshopspringbootmongodb.dto.AuthorDTO;
import dev.leolimaf.workshopspringbootmongodb.dto.CommentDTO;
import dev.leolimaf.workshopspringbootmongodb.repositories.PostRepository;
import dev.leolimaf.workshopspringbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Let's go!", "I'm gonna travel to São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good morning!", "Hey guys! Good morning!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Have a nice trip!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy it!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Have a good one!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Collections.singletonList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
