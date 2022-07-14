package org.rossedth.adaptable_fsm;

import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.EventHandler;

public class Recognized implements EventHandler<AbstractEvent> {

    public void handleEvent(AbstractEvent event) {
        System.out.println("Recognized sequence.");
    }

}