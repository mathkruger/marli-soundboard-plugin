package com.mathkruger.marlisoundboard.events;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.users.UserExitRoomEvent;
import com.mathkruger.marlisoundboard.utilities.models.ControlMarliAudioWebMessage;
import com.mathkruger.marlisoundboard.utilities.models.JavascriptCallbackComposer;

public class roomExit implements EventListener {
    @EventHandler
    public static void onUserExitRoomEvent(UserExitRoomEvent e) {
        e.habbo.getClient().sendResponse(new JavascriptCallbackComposer(new ControlMarliAudioWebMessage("parar", null)));
    }
}
