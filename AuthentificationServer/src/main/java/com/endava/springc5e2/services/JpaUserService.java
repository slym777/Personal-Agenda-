package com.endava.springc5e2.services;

import com.endava.springc5e2.entities.User;
import com.endava.springc5e2.model.SecurityUser;
import com.endava.springc5e2.repositories.UserRepository;
import org.dom4j.util.UserDataElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByUsername(username);

        return new SecurityUser(user.orElseThrow(() -> new UsernameNotFoundException("Authentification Error")));
    }
}
