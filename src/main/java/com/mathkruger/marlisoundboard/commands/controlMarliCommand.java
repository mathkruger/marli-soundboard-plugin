package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.users.Habbo;
import com.mathkruger.marlisoundboard.utilities.models.ControlMarliAudioWebMessage;
import com.mathkruger.marlisoundboard.utilities.models.JavascriptCallbackComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class controlMarliCommand extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(playMarliCommand.class);
    private static final String[] availableCommands = new String[]{ "pausar", "parar", "volume" };

    public controlMarliCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) throws Exception {
        try {
            if (strings.length >= 2) {
                String command = strings[1];

                Habbo habbo = gameClient.getHabbo();
                Room room = habbo.getHabboInfo().getCurrentRoom();

                if (Arrays.asList(this.availableCommands).contains(command)) {
                    if (room.hasRights(habbo)) {
                        String argument = null;

                        if (command == "volume") {
                            if (strings.length == 3) {
                                argument = strings[2];
                            }
                            else {
                                habbo.whisper("Você precisa passar um valor de 0 a 100 para o volume!");
                                return true;
                            }
                        }

                        ControlMarliAudioWebMessage message = new ControlMarliAudioWebMessage(command, argument);
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
