package pl.com.britenet.kta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.com.britenet.kta.entity.user.Permission;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.entity.user.RoleType;
import pl.com.britenet.kta.entity.user.User;
import pl.com.britenet.kta.repositories.RoleRepository;
import pl.com.britenet.kta.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class KtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KtaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) throws Exception {
        return args -> {
            ArrayList<User> users = new ArrayList<>();

            Set<Permission> es = new HashSet<>();
            es.add(new Permission("read"));
            es.add(new Permission("write"));
            es.add(new Permission("update"));
            Role admin = new Role(null, RoleType.ADMINISTRATOR, es);

            Set<Permission> es1 = new HashSet<>();
            es1.add(new Permission("read"));
            Role terapueuta = new Role(null, RoleType.TERAPEUTA, es1);

            roleRepository.save(terapueuta);
            roleRepository.save(admin);

            users.add(User.builder().email("email1@com.pl").role(admin).build());
            users.add(User.builder().email("email2@com.pl").role(terapueuta).build());
            users.add(User.builder().email("email3@com.pl").build());
            userRepository.save(users);

            userRepository.findAll().forEach(System.out::println);
        };
    }
}
