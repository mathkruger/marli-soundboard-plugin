package com.mathkruger.marlisoundboard.utilities.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class PlayMarliAudioWebMessage {
    public String header;
    public JsonObject data;

    public PlayMarliAudioWebMessage(String audioName) {
        this.header = "marli_audio_play";
        this.data = new JsonObject();
        this.data.add("audioId", new JsonPrimitive(audioName));
    }
}
