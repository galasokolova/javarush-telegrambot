package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;
import static com.github.javarushcommunity.jrtb.command.CommandUtils.getChatId;

public class HelpCommand implements Command{
    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE_TEMPLATE = """
        ✨<b>Доступные команды</b>✨
  
        <b>Начать\\закончить работу с ботом</b>
        
        %s - начать работу со мной
        %s - приостановить работу со мной
        
        %s  - получить помощь в работе со мной
        %s - узнать, сколько активных пользователей
        
        <b>Работа с подписками на группы:</b>
        
        %s - подписаться на группу статей
        %s - получить список групп, на которые подписан
        """;
    public static final String HELP_MESSAGE = String.format(HELP_MESSAGE_TEMPLATE,
            START.getName(),
            STOP.getName(),

            HELP.getName(),
            STAT.getName(),

            ADD_GROUP_SUB.getName(),
            LIST_GROUP_SUB.getName());



    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update), HELP_MESSAGE);
    }
}
