package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadTexts {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadTexts.class);

    public static void ILoadTexts() throws Exception {
        try {
            Emulator.getTexts().register("commands.description.cmd_marli", ":marli <tocar [musica] | pausar | parar>");
            Emulator.getTexts().register("cmd_marli.keys", "marli");

            Emulator.getTexts().register("commands.description.cmd_louvarMarli", ":louvarMarli");
            Emulator.getTexts().register("cmd_louvarMarli.keys", "louvarMarli");
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while loading texts", e);
        }
    }

}
