package com.betacom.ut.dto.output;

import com.betacom.ut.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginDTO {
	
	private Integer id; 
	private String userName;
	private Roles role;
}
