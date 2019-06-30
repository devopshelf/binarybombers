package com.org.infy.binary.exception;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
public class PaginationErrorResponse {
private int errorCode;
private String message;
// Setter Getters
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}