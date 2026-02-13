package br.com.springbootnotificationstrategy.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.springbootnotificationstrategy.handler.dto.ApiErrorMessage;
import br.com.springbootnotificationstrategy.handler.exception.NotificationChannelNotFound;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

	
	@ExceptionHandler(NotificationChannelNotFound.class)
	public ResponseEntity<ApiErrorMessage> notificationChannelNotFound(NotificationChannelNotFound exception, 
			HttpServletRequest request
			){
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ApiErrorMessage
						.builder()
						.timestamp(LocalDateTime.now())
						.message(exception.getMessage())
						.build());

		
	}
	
	
}
