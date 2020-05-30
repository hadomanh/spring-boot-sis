package hust.hadm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {
	
	// not found 
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException exception){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
												exception.getMessage(), 
												System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// wrong syntax 
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(WrongSyntaxException exception){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
												exception.getMessage(), 
												System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	// entity already exists
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EntityExistsException exception){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(),
												exception.getMessage(), 
												System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
		
	}
	
	// all
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
												exception.getMessage(), 
												System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
