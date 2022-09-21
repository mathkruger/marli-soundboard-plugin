package com.mathkruger.marlisoundboard.utilities.models;

import com.eu.habbo.messages.rcon.RCONMessage;
import com.google.gson.Gson;

public class PlayMarliAudio extends RCONMessage {
    public PlayMarliAudio(Class type) {
        super(type);
    }

    @Override
    public void handle(Gson gson, Object o) {

    }
}
