package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//atriutos
	private Date timestamp; //do java.util
	private String message;
	private String details;
	
	//construtor da classe
	public ExceptionResponse(Date timestamp, String details, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		
	}

	
	public Date getTimestamp() {
		return timestamp;
	}

	
	public String getMessage() {
		return message;
	}
	
	public String getDetails() {
		return details;
	}
	

}
