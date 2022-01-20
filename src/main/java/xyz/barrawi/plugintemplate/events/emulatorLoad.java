package xyz.barrawi.plugintemplate.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.emulator.EmulatorLoadedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.barrawi.plugintemplate.utilities.checkDatabase;
import xyz.barrawi.plugintemplate.utilities.loadConfig;
import xyz.barrawi.plugintemplate.utilities.loadPlayerCommands;
import xyz.barrawi.plugintemplate.utilities.loadTexts;

import java.io.IOException;

public class emulatorLoad implements EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(emulatorLoad.class);

    @EventHandler
    public static void onEmulatorLoaded(EmulatorLoadedEvent event) throws IOException {

        try {
            loadPlayerCommands.loadPlayerCommands();
            loadConfig.loadConfig();
            loadTexts.loadTexts();
            checkDatabase.checkDatabase();

            LOGGER.info(" [Plugin Template] Plugin Template has been loaded!");
        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Failed to load Plugin Template!", e);
        }
    }

}
