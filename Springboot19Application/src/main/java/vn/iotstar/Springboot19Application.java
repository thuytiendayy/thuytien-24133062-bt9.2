package vn.iotstar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import vn.iotstar.entity.Role;
import vn.iotstar.repository.RoleRepository;

@SpringBootApplication
public class Springboot19Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot19Application.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {

                    return roleRepository.save(
                        Role.builder()
                            .name("ROLE_USER")
                            .build()
                    );

                });

        };
    }
}