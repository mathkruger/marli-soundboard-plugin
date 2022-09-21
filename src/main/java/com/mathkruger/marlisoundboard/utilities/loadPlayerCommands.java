package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mathkruger.marlisoundboard.commands.kissesCommand;

public class loadPlayerCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadPlayerCommands.class);

    public static void ILoadPlayerCommands() {
        try {
            CommandHandler.addCommand(
                    new kissesCommand("cmd_kisses", Emulator.getTexts().getValue("cmd_kisses.keys").split(";")));
        } catch (Exception ex) {
            LOGGER.error(" [Marli Soundboard] Error while loading player commands: ", ex);
        }
    }

}
