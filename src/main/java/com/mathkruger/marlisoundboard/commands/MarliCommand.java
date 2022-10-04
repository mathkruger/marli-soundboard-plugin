package com.mathkruger.marlisoundboard.commands;

import com.eu.habbo.habbohotel.commands.Command;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.users.Habbo;
import com.mathkruger.marlisoundboard.models.MarliSong;
import com.mathkruger.marlisoundboard.models.messages.ClearSongListWebMessage;
import com.mathkruger.marlisoundboard.models.messages.ControlMarliAudioWebMessage;
import com.mathkruger.marlisoundboard.models.messages.JavascriptCallbackComposer;
import com.mathkruger.marlisoundboard.models.messages.SongsListWebMessage;
import com.mathkruger.marlisoundboard.models.messages.WebMessage;
import com.mathkruger.marlisoundboard.utilities.CheckDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class MarliCommand extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarliCommand.class);
    private static final String[] availableCommands = new String[]{ "pausar", "parar", "tocar", "listar", "fechar_lista" };

    public MarliCommand(String permission, String[] keys) {
        super(permission, keys);
    }

    @Override
    public boolean handle(GameClient gameClient, String[] strings) {
        try {
            if (strings.length >= 2) {
                String command = strings[1];

                Habbo habbo = gameClient.getHabbo();
                Room room = habbo.getHabboInfo().getCurrentRoom();

                if (Arrays.asList(this.availableCommands).contains(command)) {
                    if (room.hasRights(habbo)) {
                        WebMessage message = null;

                        switch (command) {
                            case "pausar":
                            case "parar":
                                message = new ControlMarliAudioWebMessage(command, null);
                                break;
                            case "tocar":
                                String argument = null;

                                if (strings.length == 3)
                                    argument = strings[2];

                                message = new ControlMarliAudioWebMessage(command, argument);
                                break;

                            case "listar":
                                List<MarliSong> songs = CheckDatabase.IGetMarliSongsList();
                                message = new SongsListWebMessage(songs);
                                break;

                            case "fechar_lista":
                                message = new ClearSongListWebMessage();
                                break;
                        }

                        room.sendComposer(new JavascriptCallbackComposer(message).compose());
                    }
                    else {
                        habbo.whisper("Você não tem direitos pra fazer isso nesse quarto.");
                    }
                }
                else {
                    habbo.whisper("Esse comando ainda não é suportado, utilize 'tocar <musica>', 'pausar' ou 'parar'");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao executar o comando", e);
        }

        return true;
    }
}
