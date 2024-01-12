package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String HELP_MESSAGE_TEMPLATE = """
        ✨<b>Доступные команды</b>✨
        
        <b>Начать\\закончить работу с ботом</b>
        %s - начать работу со мной
        %s - приостановить работу со мной
        %s  - получить помощь в работе со мной
        %s - узнать, сколько активных пользователей
        """;

    public static final String HELP_MESSAGE = String.format(HELP_MESSAGE_TEMPLATE,
            START.getCommandName(),
            STOP.getCommandName(),
            HELP.getCommandName(),
            STAT.getCommandName());


    public HelpCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(
                        it -> {
                            it.setActive(true);
                            telegramUserService.save(it);
                        });
    }
}
