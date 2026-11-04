package com.betacom.ut.services.implementations;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.betacom.ut.dto.input.LoginReq;
import com.betacom.ut.dto.output.LoginDTO;
import com.betacom.ut.models.Utente;
import com.betacom.ut.repositories.IUtenteRepository;
import com.betacom.ut.services.interfaces.IAuthServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthImpl implements IAuthServices {

    private final AuthenticationManager authenticationManager;
    private final IUtenteRepository utenteRepository;

    @Override
    public LoginDTO login(LoginReq req) throws Exception{

        // Verifica username e password
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                req.getUserName(),
                req.getPassword()
            )
        );

        // Recupera l'utente dopo l'autenticazione
        Utente utente = utenteRepository.findByUserName(req.getUserName())
            .orElseThrow(() -> new UsernameNotFoundException("user_not_found")
            );

        return LoginDTO.builder()
        		.id(utente.getId())
        		.userName(utente.getUserName())
        		.role(utente.getRole())
        		.build();
        
    }
}