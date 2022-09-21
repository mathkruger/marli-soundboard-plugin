package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.habbohotel.users.Habbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class kissesCommand extends Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(kissesCommand.class);

    public kissesCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {

        try {

            final Room room = gameClient.getHabbo().getHabboInfo().getCurrentRoom();

            if (strings.length >= 2) {
                Habbo habbo = room.getHabbo(strings[1]);

                if (habbo != null) {

                    if (habbo != gameClient.getHabbo()) {
                        if (habbo.getRoomUnit().getCurrentLocation()
                                .distance(gameClient.getHabbo().getRoomUnit().getCurrentLocation()) <= 1.5) {

                            String[] KissEnable = Emulator.getConfig().getValue("cmd_kisses.effect").split(";");

                            habbo.getRoomUnit().lookAtPoint(gameClient.getHabbo().getRoomUnit().getCurrentLocation());
                            gameClient.getHabbo().getRoomUnit().lookAtPoint(habbo.getRoomUnit().getCurrentLocation());

                            gameClient.getHabbo().talk(Emulator.getTexts().getValue("cmd_kisses.kisser").replace(
                                    "%user%", habbo.getHabboInfo().getUsername()), RoomChatMessageBubbles.HEARTS);
                            habbo.talk(
                                    Emulator.getTexts().getValue("cmd_kisses.kissed").replace("%user%",
                                            gameClient.getHabbo().getHabboInfo().getUsername()),
                                    RoomChatMessageBubbles.HEARTS);

                            if (KissEnable.length > 0) {
                                room.giveEffect(gameClient.getHabbo(),
                                        Integer.valueOf(KissEnable[Emulator.getRandom().nextInt(KissEnable.length)]),
                                        10);
                                room.giveEffect(habbo,
                                        Integer.valueOf(KissEnable[Emulator.getRandom().nextInt(KissEnable.length)]),
                                        10);
                            }

                        } else {
                            gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_kisses.error.too_far")
                                    .replace("%user%", habbo.getHabboInfo().getUsername()));
                        }
                    } else {
                        gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_kisses.error.self"));
                    }

                } else {
                    gameClient.getHabbo().whisper(
                            Emulator.getTexts().getValue("cmd_kisses.error.not_found").replace("%user%", strings[1]));
                }
            } else {
                gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_kisses.error.no_user"));
            }

        } catch (Exception e) {
            LOGGER.error("Error while executing command", e);
        }

        return true;
    }
}