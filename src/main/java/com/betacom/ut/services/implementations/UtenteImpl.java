package com.betacom.ut.services.implementations;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.betacom.ut.dto.input.UtenteReq;
import com.betacom.ut.enums.Roles;
import com.betacom.ut.exceptions.AcademyException;
import com.betacom.ut.models.Utente;
import com.betacom.ut.repositories.IUtenteRepository;
import com.betacom.ut.services.interfaces.IUtenteServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UtenteImpl implements IUtenteServices{

	private final IUtenteRepository utR;
	private final PasswordEncoder encoder;
	
	
	@Transactional
	@Override
	public void create(UtenteReq req) throws Exception {
		log.debug("create {}", req);
		if (utR.existsByUserName(req.getUserName()))
			throw new AcademyException("user_exist");


		Utente acc = new Utente();
		acc.setUserName(req.getUserName());
		acc.setPwd(req.getPwd());  // encode password

		acc.setNome(req.getNome());
		acc.setCognome(req.getCognome());
		acc.setEmail(req.getEmail());
		acc.setComune(req.getCommune());
		acc.setVia(req.getVia());
		acc.setCap(req.getCap());
		acc.setTelefono(req.getTelefono());
		acc.setPwd(encoder.encode(req.getPwd()));
		acc.setRole(Roles.valueOf(req.getRole()));
	//	acc.setDataCreazione(LocalDate.now());  // creato automaticamente (vedere il model)

		acc.setSesso(req.getSesso());
		acc.setValidate(false);
		utR.save(acc);


	}

}
