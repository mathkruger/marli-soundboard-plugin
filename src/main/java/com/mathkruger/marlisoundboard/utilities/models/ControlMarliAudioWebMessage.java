package com.mathkruger.marlisoundboard.utilities.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ControlMarliAudioWebMessage extends WebMessage {
    public String header;
    public JsonObject data;

    public ControlMarliAudioWebMessage(String command, String argument) {
        this.header = "control_marli_audio";
        this.data = new JsonObject();
        this.data.add("command", new JsonPrimitive(command));
        if (argument != null) {
            this.data.add("argument", new JsonPrimitive(argument));
        }
    }
}