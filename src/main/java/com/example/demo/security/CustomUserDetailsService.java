package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService
        implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();
    private final Map<String, Map<String, Object>> meta = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Map<String, Object> registerUser(
            String name, String email, String pwd, String role) {

        Long id = idGen.getAndIncrement();
        UserDetails u = User.withUsername(email)
                .password(pwd)
                .roles(role)
                .build();

        users.put(email, u);

        Map<String, Object> m = new HashMap<>();
        m.put("userId", id);
        m.put("role", role);
        meta.put(email, m);
        return m;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        if (!users.containsKey(email))
            throw new UsernameNotFoundException("User not found");
        return users.get(email);
    }
}
