package br.com.springbootnotificationstrategy.service.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springbootnotificationstrategy.service.NotificationStrategy;

public class RedditNotificationStrategy implements NotificationStrategy {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void sendNotification(String destination, String message) {
		// TODO Auto-generated method stub
		logger.info("Notificação: [{}] enviada para o Reddit [{}]", message, destination);
	}

}
