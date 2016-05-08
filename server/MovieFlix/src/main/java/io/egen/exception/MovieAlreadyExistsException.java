package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Movie Already Exists")
public class MovieAlreadyExistsException extends Exception 
{
	private static final long serialVersionUID = 7682008926426580531L;

}
