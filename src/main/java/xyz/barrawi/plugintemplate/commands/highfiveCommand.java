package xyz.barrawi.plugintemplate.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.*;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.messages.outgoing.rooms.users.RoomUserActionComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.nimbus.State;

public class highfiveCommand extends Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(kissesCommand.class);

    public highfiveCommand(String permission, String[] keys) {
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

                            gameClient.getHabbo().talk(Emulator.getTexts().getValue("cmd_highfive.highfiver").replace(
                                    "%user%", habbo.getHabboInfo().getUsername()), RoomChatMessageBubbles.HEARTS);
                            habbo.talk(
                                    Emulator.getTexts().getValue("cmd_highfive.highfived").replace("%user%",
                                            gameClient.getHabbo().getHabboInfo().getUsername()),
                                    RoomChatMessageBubbles.HEARTS);

                            gameClient.getHabbo().getRoomUnit().lookAtPoint(habbo.getRoomUnit().getCurrentLocation());
                            habbo.getRoomUnit().lookAtPoint(gameClient.getHabbo().getRoomUnit().getCurrentLocation());

                            gameClient.getHabbo().getRoomUnit().statusUpdate(true);
                            habbo.getRoomUnit().statusUpdate(true);

                            room.sendComposer(
                                    new RoomUserActionComposer(habbo.getRoomUnit(), RoomUserAction.fromValue(1))
                                            .compose());
                            room.sendComposer(new RoomUserActionComposer(gameClient.getHabbo().getRoomUnit(),
                                    RoomUserAction.fromValue(1)).compose());

                        } else {
                            gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_highfive.error.too_far")
                                    .replace("%user%", habbo.getHabboInfo().getUsername()));
                        }
                    } else {
                        gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_highfive.error.self"));
                    }

                } else {
                    gameClient.getHabbo().whisper(
                            Emulator.getTexts().getValue("cmd_highfive.error.not_found").replace("%user%", strings[1]));
                }
            } else {
                gameClient.getHabbo().whisper(Emulator.getTexts().getValue("cmd_highfive.error.no_user"));
            }

        } catch (Exception e) {
            LOGGER.error("Error while executing command", e);
        }

        return true;
    }
}