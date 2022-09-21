package com.mathkruger.marlisoundboard.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.emulator.EmulatorLoadedEvent;
import com.mathkruger.marlisoundboard.utilities.checkDatabase;
import com.mathkruger.marlisoundboard.utilities.loadConfig;
import com.mathkruger.marlisoundboard.utilities.loadPlayerCommands;
import com.mathkruger.marlisoundboard.utilities.loadTexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class emulatorLoad implements EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(emulatorLoad.class);

    @EventHandler
    public static void onEmulatorLoaded(EmulatorLoadedEvent event) throws IOException {

        try {
            loadPlayerCommands.ILoadPlayerCommands();
            loadConfig.ILoadConfig();
            loadTexts.ILoadTexts();
            checkDatabase.ICheckDatabase();

            LOGGER.info(" [Plugin Template] Plugin Template has been loaded!");
        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Failed to load Plugin Template!", e);
        }
    }

}
