package it.mtr.robotBase.mock;

import it.unibo.iot.models.commands.ICommand;

public class CommandMock implements ICommand {
	
	private String name;
	protected String defStringRep = "COMMAND(DATA)";

	public CommandMock(String name) {
		super();
		this.name = name;
		defStringRep = defStringRep.replace("COMMAND", name);
	}

	public String getName() {
		return name;
	}

	@Override
	public String getDefStringRep() {
		return getName()+"(DATA)";
	}

}
