package com.mathkruger.marlisoundboard.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.emulator.EmulatorLoadedEvent;
import com.mathkruger.marlisoundboard.utilities.CheckDatabase;
import com.mathkruger.marlisoundboard.utilities.LoadPlayerCommands;
import com.mathkruger.marlisoundboard.utilities.LoadTexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class EmulatorLoadEvent implements EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmulatorLoadEvent.class);

    @EventHandler
    public static void onEmulatorLoaded(EmulatorLoadedEvent event) throws IOException {
        try {
            LoadPlayerCommands.ILoadPlayerCommands();
            LoadTexts.ILoadTexts();
            CheckDatabase.ICheckDatabase();

            LOGGER.info(" [Marli Soundboard] Marli Soundboard has been loaded!");
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Failed to load Marli Soundboard!", e);
        }
    }

}
