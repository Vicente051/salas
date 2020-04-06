package com.tweb.salas.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tweb.salas.dominio.User;
import com.tweb.salas.repositorio.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crear users inciales proyecto
        User dan = new User("manu",passwordEncoder.encode("manu123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","TESTJEFE");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"JEFE","TESTJEFE");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
