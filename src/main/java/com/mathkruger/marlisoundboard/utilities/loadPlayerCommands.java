package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.CommandHandler;
import com.mathkruger.marlisoundboard.commands.playMarliCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadPlayerCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadPlayerCommands.class);

    public static void ILoadPlayerCommands() {
        try {
            CommandHandler.addCommand(
                    new playMarliCommand("cmd_playMarli", Emulator.getTexts().getValue("cmd_playMarli.keys").split(";")));
        } catch (Exception ex) {
            LOGGER.error(" [Marli Soundboard] Error while loading player commands: ", ex);
        }
    }

}
