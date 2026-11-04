package com.betacom.ut.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.ut.dto.input.LoginReq;
import com.betacom.ut.dto.output.LoginDTO;
import com.betacom.ut.services.interfaces.IAuthServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/utente")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthServices authServices;

    @PostMapping("/public/login")
    public ResponseEntity<LoginDTO> login(
            @Valid @RequestBody LoginReq req) throws Exception{

        return ResponseEntity.ok(authServices.login(req));
    }
}