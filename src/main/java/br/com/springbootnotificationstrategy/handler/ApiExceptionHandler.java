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
	public ResponseEntity<ApiErrorMessage> notificationChannelNotFound(NotificationChannelNotFound exception, HttpServletRequest request){
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ApiErrorMessage
						.builder()
						.timestamp(LocalDateTime.now())
						.code(HttpStatus.BAD_REQUEST.value())
						.status(HttpStatus.BAD_REQUEST.name())
						.method(request.getMethod())
						.requestURI(request.getRequestURI())
						.message(exception.getMessage())
						.build());
		
	}
	
	
}
