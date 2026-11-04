package com.betacom.ut.exceptions;

public class AcademyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AcademyException() {
		super();
	}

	public AcademyException(String message) {
		super(message);
	}
}
