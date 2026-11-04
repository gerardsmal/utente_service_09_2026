package com.betacom.ut.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {

    @NotBlank(message = "Username obbligatorio")
    private String userName;

    @NotBlank(message = "Password obbligatoria")
    private String password;
}
