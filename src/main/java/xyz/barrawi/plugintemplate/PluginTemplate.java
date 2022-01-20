package xyz.barrawi.plugintemplate;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.HabboPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.barrawi.plugintemplate.events.emulatorLoad;

public class PluginTemplate extends HabboPlugin implements EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PluginTemplate.class);
    public static PluginTemplate INSTANCE = null;

    public static void main(String[] args) {
        System.out.println("Don't run this separately");
    }

    @Override
    public void onEnable() throws Exception {
        try {
            INSTANCE = this;
            Emulator.getPluginManager().registerEvents(this, new emulatorLoad());
        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Error while enabling plugin", e);
        }
    }

    @Override
    public void onDisable() throws Exception {
        try {
            LOGGER.info(" [Plugin Template] Plugin disabled");
        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Error while disabling plugin", e);
        }

    }

    @Override
    public boolean hasPermission(Habbo habbo, String s) {
        return false;
    }
}