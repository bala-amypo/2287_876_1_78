// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     public User registerUser(User user) {
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         if (user.getRole() == null) {
//             user.setRole("VOLUNTEER_VIEWER");
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         User user = userRepository.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
//         return org.springframework.security.core.userdetails.User.builder()
//                 .username(user.getEmail())
//                 .password(user.getPassword())
//                 .roles(user.getRole())
//                 .build();
//     }
// }
