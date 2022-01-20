package xyz.barrawi.plugintemplate.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.habbohotel.users.Habbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class petCommand extends Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(kissesCommand.class);

    public petCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {

        try {

            final Room room = gameClient.getHabbo().getHabboInfo().getCurrentRoom();
            final Habbo habbo = gameClient.getHabbo();

            if (strings.length < 2) {
                habbo.whisper(Emulator.getTexts().getValue("cmd_pet.error.no_user"));
                return true;
            }

            final Habbo targetedHabbo = room.getHabbo(strings[1]);

            if (targetedHabbo == null) {
                habbo.whisper(Emulator.getTexts().getValue("cmd_pet.error.not_found").replace("%user%", strings[1]));
                return true;
            }

            if (habbo == targetedHabbo) {
                habbo.whisper(Emulator.getTexts().getValue("cmd_pet.error.self"));
                return true;
            }

            if (targetedHabbo.getRoomUnit().getCurrentLocation()
                    .distance(habbo.getRoomUnit().getCurrentLocation()) > 1.5) {
                habbo.whisper(Emulator.getTexts().getValue("cmd_pet.error.too_far").replace("%user%",
                        targetedHabbo.getHabboInfo().getUsername()));
                return true;
            }

            final String[] KissEnable = Emulator.getConfig().getValue("cmd_kisses.effect").split(";");

            if (KissEnable.length < 0) {
                return true;
            }

            room.giveEffect(targetedHabbo, Integer.valueOf(KissEnable[Emulator.getRandom().nextInt(KissEnable.length)]),
                    10);
            room.giveEffect(habbo, Integer.valueOf(KissEnable[Emulator.getRandom().nextInt(KissEnable.length)]), 10);

            targetedHabbo.getRoomUnit().lookAtPoint(targetedHabbo.getRoomUnit().getCurrentLocation());
            habbo.getRoomUnit().lookAtPoint(habbo.getRoomUnit().getCurrentLocation());

            habbo.talk(Emulator.getTexts().getValue("cmd_pet.petter").replace("%user%",
                    targetedHabbo.getHabboInfo().getUsername()), RoomChatMessageBubbles.HEARTS);
            targetedHabbo.talk(Emulator.getTexts().getValue("cmd_pet.petted").replace("%user%",
                    habbo.getHabboInfo().getUsername()), RoomChatMessageBubbles.HEARTS);

        } catch (Exception e) {
            LOGGER.error("Error while executing command", e);
        }

        return true;
    }
}