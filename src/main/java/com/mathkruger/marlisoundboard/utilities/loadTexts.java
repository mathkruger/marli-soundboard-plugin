package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadTexts {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void ILoadTexts() throws Exception {
        try {
            Emulator.getTexts().register("commands.description.cmd_kisses", ":kisses <user>");
            Emulator.getTexts().register("cmd_kisses.keys", "kisses");
            Emulator.getTexts().register("cmd_kisses.error.no_user", "You need to specify a user.");
            Emulator.getTexts().register("cmd_kisses.error.self", "You can't kiss yourself.");
            Emulator.getTexts().register("cmd_kisses.error.too_far", "You are too far away to kiss that user.");
            Emulator.getTexts().register("cmd_kisses.error.not_found", "Could not find user %user%.");
            Emulator.getTexts().register("cmd_kisses.kisser", "You kissed %user%.");
            Emulator.getTexts().register("cmd_kisses.kissed", "%user% kissed you.");

        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while loading texts", e);
        }
    }

}
