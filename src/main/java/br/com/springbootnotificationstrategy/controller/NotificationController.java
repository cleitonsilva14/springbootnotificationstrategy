package br.com.springbootnotificationstrategy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootnotificationstrategy.dto.NotificationRequest;
import br.com.springbootnotificationstrategy.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notify")
public class NotificationController {

	private final NotificationService notificationService;
	
	@PostMapping
	public ResponseEntity<Void> send(@RequestBody @Valid NotificationRequest request){
		
		notificationService.notify(request.channel(), request.destination(), request.message());
		
		return ResponseEntity.accepted().build();
	}
	
	
}
