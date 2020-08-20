package com.spring.commandlinerunner;

import com.spring.dao.RoleRepository;
import com.spring.dao.UserRepository;
import com.spring.enums.Gender;
import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DbInit(UserRepository userRepository ,PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        /*
        Role role1 = new Role();
        role1.setId((long) 1);
        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        User user0 = new User();
        user0.setFullname("Eslam Khder");
        user0.setAge("20");
        user0.setGender(Gender.MALE);
        user0.setImage("pro.jpg");
        user0.setEmail("solom@eg.com");
        user0.setPassword(passwordEncoder.encode("123456789"));
        user0.setActive(1);
        user0.setRoles(roles);
        this.userRepository.save(user0);

       Role role1 = new Role();
        role1.setId((long) 1);
        //role1.setName("ADMIN");
        Role role2 = new Role();
        //role2.setName("CLIENT");
        role2.setId((long) 2);
        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);
        //this.roleRepository.saveAll(roles);

        User user0 = new User();
        UserProprites userp0 = new UserProprites();

        userp0.setFullname("Eslam Khder");
        userp0.setAge("20");
        userp0.setGender(Gender.MALE);
        userp0.setImage("pro.jpg");
        user0.setEmail("solom@eg.com");
        user0.setPassword(passwordEncoder.encode("123456789"));
        user0.setActive(1);
        user0.setRoles(roles);
        user0.setUserProprites(userp0);

        this.userRepository.save(user0);

       */

        /*
        // Delete all
        this.userRepository.deleteAll();
        this.roleRepository.deleteAll();

        Role role1 = new Role();
        role1.setName("ADMIN");
        Role role2 = new Role();
        role2.setName("CLIENT");
        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);
        this.roleRepository.saveAll(roles);


        User user = new User();
        user.setEmail("solomkhder@eg.com");
        user.setPassword(passwordEncoder.encode("123456789"));
        user.setGender(Gender.MALE);
        user.setActive(1);
        user.setAge("20");
        user.setRoles(roles);
        this.userRepository.save(user);


        User user1 = new User();
        user1.setEmail("eslamkhder@eg.com");
        user1.setPassword(passwordEncoder.encode("987654321"));
        user1.setGender(Gender.MALE);
        user1.setActive(1);
        user1.setAge("20");

        roles.clear();
        roles.add(role2);
        Role role3 = new Role();
        role3.setId((long) 2);
        Set<Role> roless = new HashSet<>();
        roless.add(role3);

        //this.roleRepository.saveAll(roles);
        user1.setRoles(roless);
        this.userRepository.save(user1);
*/
/*
        // Crete users
        User dan = new User("dan",passwordEncoder.encode("dan123"),"CLIENT","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"VISITOR","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
 */

    }
}
