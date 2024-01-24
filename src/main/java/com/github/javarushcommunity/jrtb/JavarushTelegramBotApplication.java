package com.github.javarushcommunity.jrtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
@EnableScheduling
@SpringBootApplication
public class JavarushTelegramBotApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(JavarushTelegramBotApplication.class, args);
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			JavarushTelegramBot myBot = applicationContext.getBean(JavarushTelegramBot.class);
			botsApi.registerBot(myBot);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
//		SpringApplication.run(JavarushTelegramBotApplication.class, args);

	}
}
