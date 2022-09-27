package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadTexts {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void ILoadTexts() throws Exception {
        try {
            Emulator.getTexts().register("commands.description.cmd_playMarli", ":playMarli <cachaca | amor | bertulina>");
            Emulator.getTexts().register("commands.description.cmd_controlMarli", ":controlMarli <pausar | parar | volume> <0 - 100>");
            Emulator.getTexts().register("cmd_playMarli.keys", "playMarli");
            Emulator.getTexts().register("cmd_controlMarli.keys", "controlMarli");
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while loading texts", e);
        }
    }

}
