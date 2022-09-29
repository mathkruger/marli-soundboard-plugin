package com.mathkruger.marlisoundboard.models;

import com.google.gson.JsonObject;

public abstract class WebMessage {
    public String header;
    public JsonObject data;
}
