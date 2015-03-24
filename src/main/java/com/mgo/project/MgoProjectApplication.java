package com.mgo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MgoProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(MgoProjectApplication.class, args);
      
    }

//    @Bean
//    CommandLineRunner init(final AccountRepository accountRepository) {
//      
//      return new CommandLineRunner() {
// 
//        @Override
//        public void run(String... arg0) throws Exception {
//        	accountRepository.save(new UserModel("user", "password",
//    				"test1", "test1", 1));
//          
//        }
//        
//      };
// 
//    }
    
    
}
