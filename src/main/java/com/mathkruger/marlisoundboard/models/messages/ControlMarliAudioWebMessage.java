package com.mathkruger.marlisoundboard.models.messages;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ControlMarliAudioWebMessage extends WebMessage {
    public ControlMarliAudioWebMessage(String command, String argument) {
        this.header = "marli_audio";
        this.data = new JsonObject();
        this.data.add("command", new JsonPrimitive(command));
        if (argument != null) {
            this.data.add("argument", new JsonPrimitive(argument));
        }
    }
}
