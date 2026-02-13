package br.com.springbootnotificationstrategy.handler.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ApiErrorMessage(
		LocalDateTime timestamp,
		Integer code,
		String status,
		String message,
		String method,
		String requestURI
		) {
}
