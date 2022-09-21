package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.users.Habbo;
import com.mathkruger.marlisoundboard.utilities.models.PlayMarliAudio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class playMarliCommand  extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(kissesCommand.class);
    private static final String[] soundsAvailable = new String[]{ "amor", "cachaca", "bertulina" };

    public playMarliCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {

        try {
            if (strings.length >= 2) {
                String soundName = strings[1];
                Habbo self = gameClient.getHabbo();

                if (Arrays.asList(soundsAvailable).contains(soundName)) {
                    Emulator.getRconServer().addRCONMessage("plugin_marli_soundboard", PlayMarliAudio.class);
                    Emulator.getGameServer().
                }
                else {
                    self.whisper("Esse som ainda não é suportado :(");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao executar o comando", e);
        }

        return true;
    }
}
