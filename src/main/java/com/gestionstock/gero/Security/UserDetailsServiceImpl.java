package com.gestionstock.gero.Security;

import com.gestionstock.gero.Repository.UtilisateurRepository;
import com.gestionstock.gero.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("class UserDetailsServiceImpl methode UserDetails loadUserByUsername");
        System.out.println("username =====: " + username);
        Utilisateur user = repo.findByUsername(username);
        System.out.println("username =====: " + username);
        System.out.println("User =   =========== == == === = = == == //// === =  " + user);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }else {

        }

        return new MyUserDetails(user);
    }
}
