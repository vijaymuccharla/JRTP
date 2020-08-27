package com.vj.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobal {

		@ExceptionHandler(value = ContactsAppException.class)
		public String handleCAEception() {
			return "error";
		}
}
