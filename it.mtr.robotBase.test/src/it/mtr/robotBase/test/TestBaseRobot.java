package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.BaseRobotCommandMock;
import it.mtr.robotBase.mock.MockBaseRobot;

import org.junit.Test;

public class TestBaseRobot {
	
	@Test
	public void testBaseRobot()	{
		BaseRobotCommandMock mockCmd = new BaseRobotCommandMock();
		MockBaseRobot brMock = new MockBaseRobot();
		brMock.execute(mockCmd);
		assertTrue("Command executed",brMock.getMockVar());
	}
}
