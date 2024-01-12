package com.github.javarushcommunity.jrtb.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();
}
