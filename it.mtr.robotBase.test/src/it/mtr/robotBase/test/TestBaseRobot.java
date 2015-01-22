package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.BaseRobotCommandMock;
import it.mtr.robotBase.mock.IncBaseRobotCommandMock;
import it.mtr.robotBase.mock.MockBaseRobot;
import it.mtr.robotBase.utils.Counter;
import it.unibo.iot.executors.baseRobot.BaseRobot;
import it.unibo.iot.executors.baseRobot.IBaseRobot;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;

import org.junit.Before;
import org.junit.Test;

public class TestBaseRobot {

	IBaseRobot baserobot;
	IBaseRobotCommand cmd;

	@Before
	public void setup() {
		baserobot = new MockBaseRobot();
		cmd = new BaseRobotCommandMock();
	}

	@Test
	public void testBaseRobot() {
		Counter c = new Counter(0);
		IncBaseRobotCommandMock inccmd = new IncBaseRobotCommandMock(c);
		baserobot.execute(inccmd);
		assertTrue("hasSideEffect", c.getVal() == 1);
		baserobot.execute(inccmd);
		assertTrue("hasSideEffect2", c.getVal() == 2);
	}
//
//	@Test
//	public void testStringRep() {
//		String defStringRep = 
//		defStringRep = defStringRep.replace("NAME", componentType.getName())
//				.replace("POS", position.getDefStringRep());
//	}
}
