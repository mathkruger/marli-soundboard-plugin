package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.commands.CommandHandler;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.users.Habbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LouvarMarliCommand extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(LouvarMarliCommand.class);

    public LouvarMarliCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {
        try {
            if (strings.length >= 2) {
                Habbo habbo = gameClient.getHabbo();

                Room marliChurch = Emulator
                        .getGameEnvironment()
                        .getRoomManager()
                        .getRoomsStaffPromoted()
                        .stream()
                        .filter(x -> "Igreja da Marli".equals(x.getName()))
                        .findFirst().get();

                habbo.goToRoom(marliChurch.getId());
                habbo.talk("Salve Marli!");
            }
        } catch (Exception ex) {
            LOGGER.error(" [Marli Soundboard] Error at LouvarMarliCommand: ", ex);
        }

        return true;
    }
}
