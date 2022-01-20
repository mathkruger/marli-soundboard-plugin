package xyz.barrawi.plugintemplate.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void loadConfig() throws Exception {
        try {
            Emulator.getConfig().register("cmd_kisses.effect", "9");
            Emulator.getConfig().register("cmd_boom.allowed_rooms", "1;2;3");
            Emulator.getConfig().register("credits.on_login", "1");
            Emulator.getConfig().register("points.on_login", "1");
            Emulator.getConfig().register("pixels.on_login", "1     ");
            Emulator.getConfig().register("loginstreak.enabled", "true");

        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Failed to load config.", e);
        }
    }

}
