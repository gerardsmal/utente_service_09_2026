package com.betacom.ut.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.betacom.ut.models.Utente;
import com.betacom.ut.repositories.IUtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUtenteRepository utenteRepository;
    /*
     * Quando un utente tenta il login
     *  Spring Security chiama loadUserByUsername().
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Utente utente = utenteRepository
            .findByUserName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));

        return User.builder()
            .username(utente.getUserName())
            .password(utente.getPwd())
            .roles(utente.getRole().name())
            .build();
    }
}
