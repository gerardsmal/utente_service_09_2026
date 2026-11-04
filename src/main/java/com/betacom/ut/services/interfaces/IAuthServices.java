package com.betacom.ut.services.interfaces;

import com.betacom.ut.dto.input.LoginReq;
import com.betacom.ut.dto.output.LoginDTO;

public interface IAuthServices {
	LoginDTO  login(LoginReq req) throws Exception;

}
