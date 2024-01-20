package com.github.javarushcommunity.jrtb.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(schema = "jrtb_db", name = "tg_user")
@EqualsAndHashCode(exclude = "groupSubs")
public class TelegramUser {
    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<GroupSub> groupSubs;

}
