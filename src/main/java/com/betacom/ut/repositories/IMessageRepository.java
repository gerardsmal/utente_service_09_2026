package com.betacom.ut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.ut.models.Messaggi;

public interface IMessageRepository extends JpaRepository<Messaggi, String>{

}
