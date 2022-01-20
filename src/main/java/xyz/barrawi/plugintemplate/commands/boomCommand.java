package xyz.barrawi.plugintemplate.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.habbohotel.users.Habbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class boomCommand extends Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(boomCommand.class);

    public boomCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {

        try {

            final Room room = gameClient.getHabbo().getHabboInfo().getCurrentRoom();

            boolean allowedRoom = Arrays.stream(Emulator.getConfig().getValue("cmd_boom.allowed_rooms").split(";"))
                    .anyMatch(String.valueOf(room.getId())::equals);

            if (allowedRoom) {
                if (strings.length >= 2) {
                    Habbo habbo = room.getHabbo(strings[1]);

                    if (habbo != null) {

                        if (habbo != gameClient.getHabbo()) {
                            if (habbo.getRoomUnit().getCurrentLocation()
                                    .distance(gameClient.getHabbo().getRoomUnit().getCurrentLocation()) <= 1.5) {

                                habbo.getRoomUnit()
                                        .lookAtPoint(gameClient.getHabbo().getRoomUnit().getCurrentLocation());
                                gameClient.getHabbo().getRoomUnit()
                                        .lookAtPoint(habbo.getRoomUnit().getCurrentLocation());

                                gameClient.getHabbo().talk(Emulator.getTexts().getValue("cmd_boom.boomer").replace(
                                        "%user%", habbo.getHabboInfo().getUsername()), RoomChatMessageBubbles.THUNDER);
                                habbo.talk(
                                        Emulator.getTexts().getValue("cmd_boom.boomed").replace("%user%",
                                                gameClient.getHabbo().getHabboInfo().getUsername()),
                                        RoomChatMessageBubbles.SKELETON);
                                room.kickHabbo(habbo, true);

                            } else {
                                gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_boom.error.too_far")
                                        .replace("%user%", habbo.getHabboInfo().getUsername()));
                            }
                        } else {
                            gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_boom.error.self"));
                        }

                    } else {
                        gameClient.getHabbo().whisper(
                                Emulator.getTexts().getValue("cmd_boom.error.not_found").replace("%user%", strings[1]));
                    }
                } else {
                    gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_kisses.error.no_user"));
                }
            } else {
                gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_boom.error.not_allowed_room"));
            }
        } catch (Exception e) {
            LOGGER.error("Error while executing command", e);
        }

        return true;
    }
}