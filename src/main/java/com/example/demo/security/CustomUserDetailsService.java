package com.example.demo.security;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final VolunteerProfileRepository volunteerProfileRepository;

    public CustomUserDetailsService(VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        VolunteerProfile vp = volunteerProfileRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // For demo, we don't persist password hashes in VolunteerProfile; in a real app this would be separate.
        // Use a placeholder password; authentication flow in AuthController should verify by external store.
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        return new User(vp.getEmail(), "$2a$10$Qe3Qm2S6M3oY8PzQz4E0EOsHjq5sHao3hY3m0GHHH9m3b0k2D9h2y", Collections.singleton(authority));
    }
}
