package it.unibo.robotAreaSystem;

import it.unibo.contactEvent.interfaces.IEventItem;
import it.unibo.contactEvent.platform.ContactEventPlatform;

public class EvAreaTask extends EvAreaTaskSupport {

	String[] states = { "S1", "S2", "S3", "S4" };
	

	public EvAreaTask(String name, String[] eventId) throws Exception {
		super(name, eventId);
		curstate = states[0];
	}

	@Override
	protected void stateControl() throws Exception {
		if (!this.isTerminated()) {
			if (curstate.equals(states[0])) {
				nullState();
			} else if (curstate.equals(states[1])) {
				stateHadleEvent();
			} else if (curstate.equals(states[2])) {
				nullState();
			} else if (curstate.equals(states[3])) {
				stateHadleEvent();
			}
		}
		;
	}

	protected void nullState() throws Exception {
		
		curEvent = this.getEventItem();
		if(curEvent != null)
			handleEvent(curEvent);
		
		String[] events = new String[] { "lineDetected", "lineUndetected" };
		String[] nextStates = null;
		if (curstate.equals(states[0])) {
			nextStates = new String[] { states[1], curstate };
		}
		if (curstate.equals(states[2])) {
			nextStates = new String[] { states[3], curstate };
		}

		showMsg("nullState " + curstate + " -> " + nextStates[0]);

		transitions(events, nextStates);
	}

	@Override
	protected void stateHadleEvent() throws Exception {
		curEvent = this.getEventItem();
		handleEvent(curEvent);

		String[] events = new String[] { "lineUndetected", "lineDetected" };
		String[] nextStates = null;
		if (curstate.equals(states[1])) {
			nextStates = new String[] { states[2], curstate };
		}
		if (curstate.equals(states[3])) {
			nextStates = new String[] { states[0], curstate };
		}

		showMsg("stateHandleEvent " + curstate + " -> " + nextStates[0]);

		transitions(events, nextStates);
	}

	@Override
	protected void handleEvent(IEventItem curEvent) {
		printEvent(curEvent);
		if (curstate.equals(states[2]))
			raiseEventArea("Enter", curEvent.getMsg());
		if (curstate.equals(states[0]))
			raiseEventArea("Exit", curEvent.getMsg());
	}

	private void raiseEventArea(String msg, String name) {
		msg = name + " " + msg;
		showMsg(msg);
		try {
			ContactEventPlatform.getPlatform().raiseEvent(getName(), "Signal", msg);
		} catch (Exception e) {
			println("ERROR Raise Event " + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void printEvent(IEventItem ev) {
		String msg = getName() + ":" + ev.getEventId() + " msg=" + ev.getMsg()
				+ " emitter=" + ev.getSubj();
		showMsg("--------------------------------------------------");
		showMsg(msg + " state: " + curstate);
		showMsg("--------------------------------------------------");
	}

}
