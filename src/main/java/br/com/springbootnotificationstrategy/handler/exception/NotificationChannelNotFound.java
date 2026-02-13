package br.com.springbootnotificationstrategy.handler.exception;


public class NotificationChannelNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotificationChannelNotFound(String message) {
		super(message);
	}
	
}
