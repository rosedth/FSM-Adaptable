package org.rossedth.adaptable_fsm;
import org.jeasy.states.api.AbstractEvent;

class AEvent extends AbstractEvent {

    public AEvent() {
        super("AEvent");
    }

    protected AEvent(String name) {
        super(name);
    }

}