package com.santiago.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.santiago.workshopmongo.domain.Post;
import com.santiago.workshopmongo.domain.User;
import com.santiago.workshopmongo.dto.AuthorDTO;
import com.santiago.workshopmongo.repository.PostRepository;
import com.santiago.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {
    
    	
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       sdf.setTimeZone(TimeZone.getTimeZone("GMT"));;
       
       userRepository.deleteAll();
       postRepository.deleteAll();

       User maria = new User(null, "Maria Brown", "maria@gmail.com");
       User alex = new User(null, "Alex Green", "alex@gmail.com");
       User bob = new User(null, "Bob Grey", "bob@gmail.com");
       User santiago = new User(null, "Thyago Santiago", "ssantiagotl@gmail.com");
       
       userRepository.saveAll(Arrays.asList(maria, alex, bob, santiago));
       
       Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem!", "Vou viajar para Dublin. Abraços!", new AuthorDTO(maria));
       Post post2 = new Post(null, sdf.parse("23/03/2020"), "Bom dia!", "Um ótimo dia para estudar!", new AuthorDTO(maria));
    
       postRepository.saveAll(Arrays.asList(post1, post2));
       
       maria.getPosts().addAll(Arrays.asList(post1, post2));
       userRepository.save(maria);

    }
}