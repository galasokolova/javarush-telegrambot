package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void save (TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId (String chatId);
}
