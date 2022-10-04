package com.mathkruger.marlisoundboard.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.users.UserExitRoomEvent;
import com.mathkruger.marlisoundboard.models.messages.ClearSongListWebMessage;
import com.mathkruger.marlisoundboard.models.messages.ControlMarliAudioWebMessage;
import com.mathkruger.marlisoundboard.models.messages.JavascriptCallbackComposer;

public class RoomExitEvent implements EventListener {
    @EventHandler
    public static void onUserExitRoomEvent(UserExitRoomEvent e) {
        e.habbo.getClient().sendResponse(new JavascriptCallbackComposer(new ControlMarliAudioWebMessage("parar", null)));
        e.habbo.getClient().sendResponse(new JavascriptCallbackComposer(new ClearSongListWebMessage()));
    }
}
