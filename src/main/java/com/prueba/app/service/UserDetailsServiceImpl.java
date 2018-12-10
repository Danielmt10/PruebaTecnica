package com.prueba.app.service;

import com.prueba.app.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService service;

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.fingById(username);
        System.out.println("\n\n\n\n\n\n\n" + logger.getName() + "\n\n\n\n\n\n\n\n");
        List<GrantedAuthority>authority = new ArrayList<GrantedAuthority>();
        authority.add(new SimpleGrantedAuthority(user.getType().getName()));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.isActive(), true, true, true, authority);
    }
}
