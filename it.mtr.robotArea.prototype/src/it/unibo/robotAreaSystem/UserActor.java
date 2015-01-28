package it.unibo.robotAreaSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.unibo.contactEvent.platform.ContactEventPlatform;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;
import it.unibo.qactors.QActor;

public class UserActor extends QActor {

	public UserActor(String actorId, ActorContext myCtx, IOutputView outView) {
		super(actorId, myCtx, outView);
	}

	@Override
	protected void doJob() throws Exception {
		String cmd = "";
		while (!cmd.equals("e") && !cmd.equals("q")) {
			cmd = waitForUserCommand();
			executeCmd(cmd);
		}
		outView.addOutput("bye bye");
	}

	private void executeCmd(String cmd) {
		switch (cmd) {
		case "halt":
			emitEvent("halt", "robotArea");
			break;
		case "h":
			emitEvent("halt", "robotArea");
			break;
		case "ld":
			emitEvent("lineDetected", "robotArea");
			break;
		case "lud":
			emitEvent("lineUndetected", "robotArea");
			break;
		case "obs":
			emitEvent("obstacle", "robotArea");
			break;

		default:
			break;
		}
	}
	
	private void emitEvent(String evId, String evContent){
		println(getName() + " emits " + evId + " " + evContent);
		this.platform.raiseEvent(getName(), evId, evContent);
	}

	private String waitForUserCommand() {
		outView.addOutput("cmd: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return line;
	}

}
