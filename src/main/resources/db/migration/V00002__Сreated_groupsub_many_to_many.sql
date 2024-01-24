-- ensure that the tables with these names are removed before creating a new one.
DROP TABLE IF EXISTS group_sub;
DROP TABLE IF EXISTS group_x_user;

CREATE TABLE group_sub (
                           id INT,
                           title VARCHAR(100),
                           last_article_id INT,
                           PRIMARY KEY (id)
);

CREATE TABLE group_x_user (
                              group_sub_id INT NOT NULL,
                              user_id BIGINT NOT NULL,  -- Изменено на BIGINT для соответствия с типом chat_id в tg_user
                              FOREIGN KEY (user_id) REFERENCES tg_user(chat_id),
                              FOREIGN KEY (group_sub_id) REFERENCES group_sub(id),
                              UNIQUE(user_id, group_sub_id)
);

