package com.org.infy.binary.exception;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
public class PaginationException extends RuntimeException {
	private static final long serialVersionUID = -123L;
	private String errorMessage;

	@Override
	public String getMessage() {
		return errorMessage;
	}

	public PaginationException() {
		super();
	}

	public PaginationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}