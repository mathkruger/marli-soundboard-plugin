package com.mathkruger.marlisoundboard.models.messages;

import com.eu.habbo.messages.ServerMessage;
import com.eu.habbo.messages.outgoing.MessageComposer;
import com.eu.habbo.messages.outgoing.Outgoing;
import com.google.gson.Gson;

public class JavascriptCallbackComposer extends MessageComposer {
    private final WebMessage webMessage;

    public JavascriptCallbackComposer(WebMessage message) {
        this.webMessage = message;
    }
    @Override
    protected ServerMessage composeInternal() {
        this.response.init(Outgoing.NuxAlertComposer);
        String jsonMessage = new Gson().toJson(webMessage).replace("/", "&#47;");
        this.response.appendString("habblet/open/" + jsonMessage);
        return this.response;
    }
}
