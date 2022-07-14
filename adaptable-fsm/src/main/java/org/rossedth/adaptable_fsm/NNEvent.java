package org.rossedth.adaptable_fsm;
import org.jeasy.states.api.AbstractEvent;

public class NNEvent extends AbstractEvent {

    public NNEvent() {
        super("NNEvent");
    }

    protected NNEvent(String name) {
        super(name);
    }

}