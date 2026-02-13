package br.com.springbootnotificationstrategy.dto;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequest (
	@NotBlank String channel,
	@NotBlank String destination,
	@NotBlank String message
){
	
}
