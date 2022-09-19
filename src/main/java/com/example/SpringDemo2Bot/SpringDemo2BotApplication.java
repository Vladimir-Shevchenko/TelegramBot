package com.example.SpringDemo2Bot;

import com.example.SpringDemo2Bot.settings.CommandsBot;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class SpringDemo2BotApplication {

	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(SpringDemo2BotApplication.class, args);
		CommandsBot bot = new CommandsBot();
		TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
		telegramBot.registerBot(bot);

	}

}
