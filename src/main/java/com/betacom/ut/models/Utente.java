package com.betacom.ut.models;

import java.time.LocalDate;

import com.betacom.ut.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="utente")
public class Utente {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 100)
	private String userName;

	@Column(nullable = false, length = 255)
	private String pwd;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Roles  role;
	
	private String nome;
	private String cognome;
	private Boolean sesso;
	private String email;
	private String telefono;
	private String via;
	private String comune;
	private String cap;

	@Column (name="email_validation",
			nullable= false,
			columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean validate;


	@Column (name="data_creazione")
	private LocalDate dataCreazione; 
	@PrePersist
    public void prePersist() {
        if (dataCreazione == null) {
            dataCreazione = LocalDate.now();
        }

        if (validate == null) {
            validate = false;
        }
    }
}
