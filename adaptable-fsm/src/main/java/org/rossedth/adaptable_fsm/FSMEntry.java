package org.rossedth.adaptable_fsm;

public class FSMEntry {

	private String entry;
    private String eventClass;
    private String eventName;

	public FSMEntry(String entry, String eventClass, String eventName) {
		this.entry = entry;
		this.eventClass = eventClass;
		this.eventName = eventName;
	}
	
	public FSMEntry() {}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getEventClass() {
		return eventClass;
	}

	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FSMEntry");
        sb.append("{entry='").append(entry).append('\'');
        sb.append(", eventClass='").append(eventClass).append('\'');
        sb.append(", eventName='").append(eventName);
        sb.append("'}");
        return sb.toString();
    }
}

