package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    /**
     * Save provided {@link TelegramUser} entity.
     *
     * @param  telegramUser provided telegram user.
     */
    void save(TelegramUser telegramUser);

    /**
     * Find all active {@link TelegramUser}.
     *
     * @return the collection of the active {@link TelegramUser} objects.
     */
    List<TelegramUser> findAllActiveUsers();

    /**
     * Find all inactive {@link TelegramUser}
     *
     * @return the collection of the inactive {@link TelegramUser} objects.
     */
    List<TelegramUser> findAllInActiveUsers();

    /**
     * Find {@link TelegramUser} by chatId.
     *
     * @param chatId provided Chat ID
     * @return {@link TelegramUser} with provided chat ID or null otherwise.
     */
    Optional<TelegramUser> findByChatId(Long chatId);
}
