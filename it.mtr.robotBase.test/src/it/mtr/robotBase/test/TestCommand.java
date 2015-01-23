package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.CommandMock;
import it.unibo.iot.models.commands.Command;
import it.unibo.iot.models.commands.ICommand;
import it.unibo.iot.models.commands.baseRobot.BaseRobotAngle;
import it.unibo.iot.models.commands.baseRobot.BaseRobotCommand;
import it.unibo.iot.models.commands.baseRobot.BaseRobotSpeed;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotAngle;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotSpeed;
import it.unibo.iot.utils.StringUtils;

import org.junit.Before;
import org.junit.Test;

public class TestCommand {

	ICommand command;
	IBaseRobotCommand baseCmd;
	IBaseRobotSpeed speed;
	IBaseRobotAngle angle;
	String cmdName = "test";

	@Before
	public void setup() {
		command = new CommandMock(cmdName);
	}

	@Before
	public void setupForBase() {
		speed = new BaseRobotSpeed(100);
		angle = new BaseRobotAngle(0);
		baseCmd = new BaseRobotCommand(speed, angle) {
		};
	}

	@Test
	public void testStrRep() {
		String cmdRepStart = cmdName + "(";
		String cmdRepEnd = ")";
		assertTrue("goodStartRep",
				command.getDefStringRep().startsWith(cmdRepStart));
		assertTrue("goodEndRep", command.getDefStringRep().endsWith(cmdRepEnd));
	}

	@Test
	public void testBaseRobotCmdStrRep() {
		String stringRepStart, stringRepEnd;
		stringRepStart = "robotCommand(";
		if (angle == null)
			stringRepEnd = "," + speed.getStringRep() + ")";
		else
			stringRepEnd = "," + speed.getStringRep() + ","
					+ angle.getStringRep() + ")";
		assertTrue("goodStartRep",
				baseCmd.getDefStringRep().startsWith(stringRepStart));
		assertTrue("goodEndRep",
				baseCmd.getDefStringRep().endsWith(stringRepEnd));
	}
}
