DROP TABLE IF EXISTS tg_user;

-- Create tg_user table
CREATE TABLE tg_user (
                         chat_id BIGINT,  -- Изменено на BIGINT для соответствия с четвертой миграцией
                         active BOOLEAN,
                         PRIMARY KEY (chat_id)  -- Добавлен первичный ключ
);

