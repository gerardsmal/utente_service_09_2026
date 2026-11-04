package com.betacom.ut.services.implementations;

import org.springframework.stereotype.Service;

import com.betacom.ut.models.Messaggi;
import com.betacom.ut.repositories.IMessageRepository;
import com.betacom.ut.services.interfaces.IMessageServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessagesImpl  implements IMessageServices{

	private final IMessageRepository msgR;
	
	@Override
	public String get(String code) {
		log.debug("get {}", code);
		Messaggi msg = msgR.findById(code)
				.orElse( new  Messaggi(code, code));
		return msg.getMsg();
	}
}
