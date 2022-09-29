package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.CommandHandler;
import com.mathkruger.marlisoundboard.commands.MarliCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadPlayerCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadPlayerCommands.class);

    public static void ILoadPlayerCommands() {
        try {
            CommandHandler.addCommand(
                    new MarliCommand("cmd_marli", Emulator.getTexts().getValue("cmd_marli.keys").split(";")));
        } catch (Exception ex) {
            LOGGER.error(" [Marli Soundboard] Error while loading player commands: ", ex);
        }
    }

}
