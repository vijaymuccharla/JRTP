package com.vj.exceptions;

public class NoDataFoundException extends RuntimeException {
	
	public NoDataFoundException() {
		System.out.println("NoDatFoundException.NoDatFoundException()");
	}
	 
	public NoDataFoundException(String msg){
		super(msg);
	}

}
