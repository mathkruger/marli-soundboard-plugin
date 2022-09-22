package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.users.Habbo;
import com.mathkruger.marlisoundboard.utilities.models.JavascriptCallbackComposer;
import com.mathkruger.marlisoundboard.utilities.models.PlayMarliAudioWebMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class playMarliCommand  extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(playMarliCommand.class);
    private static final String[] soundsAvailable = new String[]{ "amor", "cachaca", "bertulina" };

    public playMarliCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {

        try {
            if (strings.length >= 2) {
                String soundName = strings[1];
                Habbo habbo = gameClient.getHabbo();
                Room room = habbo.getHabboInfo().getCurrentRoom();

                if (Arrays.asList(soundsAvailable).contains(soundName)) {
                    if (room.hasRights(habbo) || habbo.getHabboInfo().getRank().getLevel() >= 6) {
                        PlayMarliAudioWebMessage message = new PlayMarliAudioWebMessage(soundName);
                        room.sendComposer(new JavascriptCallbackComposer(message).compose());
                    }
                    else {
                        habbo.whisper("Você não tem direitos pra fazer isso nesse quarto.");
                    }
                }
                else {
                    habbo.whisper("Esse som ainda não é suportado :(");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao executar o comando", e);
        }

        return true;
    }
}
