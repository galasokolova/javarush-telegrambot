package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE_TEMPLATE = """
        ✨<b>Доступные команды</b>✨
        
        <b>Начать\\закончить работу с ботом</b>
        %s - начать работу со мной
        %s - приостановить работу со мной
        %s  - получить помощь в работе со мной
        """;

    public static final String HELP_MESSAGE = String.format(HELP_MESSAGE_TEMPLATE,
            START.getCommandName(),
            STOP.getCommandName(),
            HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
