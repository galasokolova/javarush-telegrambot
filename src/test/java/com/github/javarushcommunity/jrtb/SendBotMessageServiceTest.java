package com.github.javarushcommunity.jrtb;

import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavarushTelegramBot javarushBot;

    @BeforeEach
    public void init() {
        javarushBot = Mockito.mock(JavarushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);
    }

    @Test
    void shouldProperlySendMessage() throws TelegramApiException {
        //given
        Long chatId = 123L;
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId.toString());
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javarushBot).execute(sendMessage);
    }
}