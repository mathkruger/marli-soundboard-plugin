package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void ILoadConfig() throws Exception {
        try {
            Emulator.getConfig().register("cmd_kisses.effect", "9");

        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Failed to load config.", e);
        }
    }

}
