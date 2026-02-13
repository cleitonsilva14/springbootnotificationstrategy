package br.com.springbootnotificationstrategy.service;

public interface NotificationStrategy {
	
	void sendNotification(String destination, String message);
	
}
