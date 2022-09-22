package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadTexts {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void ILoadTexts() throws Exception {
        try {
            Emulator.getTexts().register("commands.description.cmd_playMarli", ":playMarli <cachaca | amor | bertulina>");
            Emulator.getTexts().register("cmd_playMarli.keys", "playMarli");
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while loading texts", e);
        }
    }

}
