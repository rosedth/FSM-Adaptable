package org.rossedth.adaptable_fsm;
import org.jeasy.states.api.AbstractEvent;

public class CEvent extends AbstractEvent {

    public CEvent() {
        super("CEvent");
    }

    protected CEvent(String name) {
        super(name);
    }

}