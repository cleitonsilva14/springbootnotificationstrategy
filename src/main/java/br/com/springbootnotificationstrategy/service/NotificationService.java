package br.com.springbootnotificationstrategy.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.springbootnotificationstrategy.handler.exception.NotificationChannelNotFound;
import br.com.springbootnotificationstrategy.service.strategy.DiscordNotificationStrategy;
import br.com.springbootnotificationstrategy.service.strategy.RedditNotificationStrategy;
import br.com.springbootnotificationstrategy.service.strategy.TelegramNotificationStrategy;
import br.com.springbootnotificationstrategy.service.strategy.WhatsappNotificationStrategy;

@Service
public class NotificationService {

	
	private final Map<String, NotificationStrategy> strategies = Map.of(
			"discord", new DiscordNotificationStrategy(),
			"telegram", new TelegramNotificationStrategy(),
			"reddit", new RedditNotificationStrategy(),
			"whatsapp", new WhatsappNotificationStrategy()
		);
	
	public void notify(String channel, String destination, String message) {
		
		// strategies.get(channel).sendNotification(destination, message);
		
		
		Optional.ofNullable(strategies.get(channel))
		.ifPresentOrElse(
				strategy -> strategy.sendNotification(destination, message), 
				() -> {
					//System.out.println("\033[31mCanal de notificação: %s inválido\033[m".formatted(channel));
					throw new NotificationChannelNotFound("Canal de notificação: %s inválido".formatted(channel));
				});
	}
}
