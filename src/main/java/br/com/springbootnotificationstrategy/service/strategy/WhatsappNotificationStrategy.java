package br.com.springbootnotificationstrategy.service.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springbootnotificationstrategy.service.NotificationStrategy;

public class WhatsappNotificationStrategy implements NotificationStrategy {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void sendNotification(String destination, String message) {
		logger.info("Notificação: [{}] enviada para o Whatsapp [{}]", message, destination);
	}

}
