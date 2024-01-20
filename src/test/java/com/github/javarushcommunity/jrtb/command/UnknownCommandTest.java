package com.github.javarushcommunity.jrtb.command;


import com.github.javarushcommunity.jrtb.command.AbstractCommandTest;
import com.github.javarushcommunity.jrtb.command.Command;
import com.github.javarushcommunity.jrtb.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
