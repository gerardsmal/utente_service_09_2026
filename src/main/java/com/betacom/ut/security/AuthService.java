package com.betacom.ut.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.betacom.ut.dto.input.LoginReq;
import com.betacom.ut.dto.output.LoginDTO;
import com.betacom.ut.models.Utente;
import com.betacom.ut.repositories.IUtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final IUtenteRepository utenteRepository;

    public LoginDTO login(LoginReq req) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                req.getUserName(),
                req.getPassword()
            )
        );

        Utente utente = utenteRepository
            .findByUserName(req.getUserName())
            .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));

        return LoginDTO.builder()
        		.id(utente.getId())
        		.userName(utente.getUserName())
        		.role(utente.getRole())
        		.build();
    }
}
