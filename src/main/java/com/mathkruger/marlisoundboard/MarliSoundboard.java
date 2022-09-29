package com.mathkruger.marlisoundboard;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.HabboPlugin;
import com.mathkruger.marlisoundboard.events.RoomExitEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mathkruger.marlisoundboard.events.EmulatorLoadEvent;

public class MarliSoundboard extends HabboPlugin implements EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarliSoundboard.class);
    public static MarliSoundboard INSTANCE = null;

    public static void main(String[] args) {
        System.out.println("Don't run this separately");
    }

    @Override
    public void onEnable() throws Exception {
        try {
            INSTANCE = this;
            Emulator.getPluginManager().registerEvents(this, new EmulatorLoadEvent());
            Emulator.getPluginManager().registerEvents(this, new RoomExitEvent());
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while enabling plugin", e);
        }
    }

    @Override
    public void onDisable() throws Exception {
        try {
            LOGGER.info(" [Marli Soundboard] Plugin disabled");
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Error while disabling plugin", e);
        }

    }

    @Override
    public boolean hasPermission(Habbo habbo, String s) {
        return true;
    }
}
