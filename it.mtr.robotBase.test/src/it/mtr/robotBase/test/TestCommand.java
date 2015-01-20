package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.CommandMock;
import it.unibo.iot.models.commands.Command;
import it.unibo.iot.models.commands.ICommand;

import org.junit.Before;
import org.junit.Test;

public class TestCommand {

	ICommand command;
	String cmdName = "test";
	
	@Before
	public void setup(){
		command = new CommandMock(cmdName);
	}
	
	@Test
	public void testStrRep(){
		String cmdRepStart = cmdName+"(";
		String cmdRepEnd = ")";
		assertTrue("goodStartRep", command.getDefStringRep().startsWith(cmdRepStart));
		assertTrue("goodEndRep", command.getDefStringRep().endsWith(cmdRepEnd));
	}
	
}
