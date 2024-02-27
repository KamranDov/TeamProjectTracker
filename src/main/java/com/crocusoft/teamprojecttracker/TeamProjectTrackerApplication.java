package com.crocusoft.teamprojecttracker;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RequiredArgsConstructor
//@Builder

public class TeamProjectTrackerApplication {


    public static void main(String[] args) {
        SpringApplication.run(TeamProjectTrackerApplication.class, args);
    }


//    @Bean
//    CommandLineRunner initialize(UserRepository userRepository, RoleRepository roleRepository) {


//                Role superAdminRole = Role.builder()
//                        .name("SUPER_ADMIN")
//                        .description("Can create Admin, Head, Employee roles and see all modules.")
//                        .build();
//                roleRepository.save(superAdminRole);
//
//                Role adminRole = Role.builder()
//                        .name("ADMIN")
//                        .description("Creates all roles except admin and can see all modules.")
//                        .build();
//                roleRepository.save(adminRole);
//
//                Role headRole = Role.builder()
//                        .name("HEAD")
//                        .description("It does not perform any operations, it can only see all modules.")
//                        .build();
//                roleRepository.save(headRole);
//
//                Role userRole = Role.builder()
//                        .name("USER")
//                        .description("He can only see the Daily Report module. There, he can change and view the report he created during the day he wrote it.")
//                        .build();
//                roleRepository.save(userRole);
//
//                User superAdminUser = User.builder()
//                        .name("Kamran")
//                        .surname("Ahmadov")
//                        .password(new BCryptPasswordEncoder().encode("superadmin"))
//                        .email("superadmin@crocusoft.com")
//                        .userActionStatus(UserActionStatus.ACTIVE)
//                    .authorities(new HashSet<>(Collections.singletonList(superAdminRole)))
//                        .build();
//
//                userRepository.save(superAdminUser);
//        };
//    }

}

