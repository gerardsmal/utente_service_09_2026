package com.betacom.ut.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.ut.dto.input.UtenteReq;
import com.betacom.ut.dto.input.ValidationGroups;
import com.betacom.ut.dto.output.ResponseDTO;
import com.betacom.ut.services.interfaces.IMessageServices;
import com.betacom.ut.services.interfaces.IUtenteServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("rest/utente")
public class UtenteController {

	private final IUtenteServices utS;
	private final IMessageServices msgS;
	
	
	@PostMapping("/public/create")
	public ResponseEntity<ResponseDTO> create(
			@RequestBody(required = true) @Validated(ValidationGroups.Create.class) UtenteReq req) throws Exception {
		ResponseDTO r = new ResponseDTO();

		utS.create(req);
		r.setMsg(msgS.get("rest_created"));
		return ResponseEntity.ok(r);
	}

}
