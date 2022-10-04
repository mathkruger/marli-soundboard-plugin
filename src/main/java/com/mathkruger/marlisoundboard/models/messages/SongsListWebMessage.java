package com.mathkruger.marlisoundboard.models.messages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mathkruger.marlisoundboard.models.MarliSong;

import java.util.List;

public class SongsListWebMessage extends WebMessage{
    public SongsListWebMessage(List<MarliSong> songs) {
        this.header = "marli_song_list";
        this.data = new JsonObject();

        JsonArray array = new JsonArray(songs.size());

        for (int i = 0; i < songs.size(); i++) {
            JsonObject object = new JsonObject();
            object.add("songId", new JsonPrimitive(songs.get(i).getSongId()));
            object.add("songName", new JsonPrimitive(songs.get(i).getSongName()));

            array.add(object);
        }

        this.data.add("songs", array);
    }
}
