package com.mathkruger.marlisoundboard.models.messages;

import com.google.gson.JsonObject;

public class ClearSongListWebMessage extends WebMessage{
    public ClearSongListWebMessage() {
        this.header = "marli_clear_song_list";
        this.data = new JsonObject();
    }
}
