package com.betacom.ut.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.ut.enums.Roles;
import com.betacom.ut.models.Utente;

public interface IUtenteRepository extends JpaRepository<Utente, Integer>{

	@Query(name="utente.selectByFilter")
	List<Utente> selectByFilter(
			@Param("userName") String userName,
			@Param("nome") String nome,
			@Param("cognome") String cognome,
			@Param("role") Roles role
	);
	
	Optional<Utente> findByUserName(String userName);
	Boolean existsByUserName(String userName);
}
