package com.mathkruger.marlisoundboard.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.users.UserExitRoomEvent;
import com.mathkruger.marlisoundboard.models.ControlMarliAudioWebMessage;
import com.mathkruger.marlisoundboard.models.JavascriptCallbackComposer;

public class RoomExitEvent implements EventListener {
    @EventHandler
    public static void onUserExitRoomEvent(UserExitRoomEvent e) {
        e.habbo.getClient().sendResponse(new JavascriptCallbackComposer(new ControlMarliAudioWebMessage("parar", null)));
    }
}
