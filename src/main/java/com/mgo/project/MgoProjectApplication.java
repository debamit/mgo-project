package com.mgo.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mgo.project.domain.User;
import com.mgo.project.repo.UserRepository;

@SpringBootApplication
public class MgoProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(MgoProjectApplication.class, args);
      
    }

    @Bean
    CommandLineRunner init(final UserRepository userRepository) {
      
      return new CommandLineRunner() {
 
        @Override
        public void run(String... arg0) throws Exception {
        	userRepository.save(new User("q.clark@young.com", "Eric", "Lopez", "Los Angeles",
        			"CA", "software engg"));
        	userRepository.save(new User("d.dutta@mgo.com", "D", "Dutta", "Charlotte",
        			"NC", "actor"));
        	userRepository.save(new User("m.test@mgo.com", "Mtest", "test", "San Deigo",
        			"CA", "Model"));
        }
        
      };
 
    }
    
    
}
