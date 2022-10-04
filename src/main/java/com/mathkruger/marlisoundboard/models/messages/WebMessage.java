package com.mathkruger.marlisoundboard.models.messages;

import com.google.gson.JsonObject;

public abstract class WebMessage {
    public String header;
    public JsonObject data;
}
