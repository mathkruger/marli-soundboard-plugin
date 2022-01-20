package xyz.barrawi.plugintemplate.utilities;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.barrawi.plugintemplate.commands.boomCommand;
import xyz.barrawi.plugintemplate.commands.highfiveCommand;
import xyz.barrawi.plugintemplate.commands.kissesCommand;
import xyz.barrawi.plugintemplate.commands.petCommand;

public class loadPlayerCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadPlayerCommands.class);

    public static void ILoadPlayerCommands() {
        try {
            CommandHandler.addCommand(
                    new kissesCommand("cmd_kisses", Emulator.getTexts().getValue("cmd_kisses.keys").split(";")));
            CommandHandler
                    .addCommand(new boomCommand("cmd_boom", Emulator.getTexts().getValue("cmd_boom.keys").split(";")));
            CommandHandler.addCommand(
                    new highfiveCommand("cmd_highfive", Emulator.getTexts().getValue("cmd_highfive.keys").split(";")));
            CommandHandler
                    .addCommand(new petCommand("cmd_pet", Emulator.getTexts().getValue("cmd_pet.keys").split(";")));

        } catch (Exception ex) {
            LOGGER.error(" [Plugin Template] Error while loading player commands: ", ex);
        }
    }

}
