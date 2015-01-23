package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mrt.robotBase.interfaces.ISimulatedWorldRef;
import it.mtr.robotBase.mock.BaseRobotCommandMock;
import it.mtr.robotBase.mock.IncBaseRobotCommandMock;
import it.mtr.robotBase.mock.MockBaseRobot;
import it.mtr.robotBase.utils.Counter;
import it.unibo.iot.baseRobot.configurator.Configurator;
import it.unibo.iot.executors.baseRobot.BaseRobot;
import it.unibo.iot.executors.baseRobot.IBaseRobot;
import it.unibo.iot.models.commands.baseRobot.BaseRobotBackward;
import it.unibo.iot.models.commands.baseRobot.BaseRobotForward;
import it.unibo.iot.models.commands.baseRobot.BaseRobotLeft;
import it.unibo.iot.models.commands.baseRobot.BaseRobotRight;
import it.unibo.iot.models.commands.baseRobot.BaseRobotSpeed;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;
import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.Position;
import it.unibo.iot.models.sensorData.PositionValue;

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
		// test utilizzando i side effect
		Counter c = new Counter(0);
		IncBaseRobotCommandMock inccmd = new IncBaseRobotCommandMock(c);
		baserobot.execute(inccmd);
		assertTrue("hasSideEffect", c.getVal() == 1);
		baserobot.execute(inccmd);
		assertTrue("hasSideEffect2", c.getVal() == 2);
	}

	@Test
	public void testForward() {
		if (baserobot instanceof ISimulatedWorldRef) {
			ISimulatedWorldRef baseRefRobot = (ISimulatedWorldRef) baserobot;
			BaseRobotForward fw = new BaseRobotForward(new BaseRobotSpeed(100));
			baserobot.execute(fw);
			assertTrue("forwardSideEffect",
					baseRefRobot.getGlobalPosition().x > 0);
		}
	}
	
	@Test
	public void testBackward() {
		if (baserobot instanceof ISimulatedWorldRef) {
			ISimulatedWorldRef baseRefRobot = (ISimulatedWorldRef) baserobot;
			BaseRobotBackward bw = new BaseRobotBackward(new BaseRobotSpeed(100));
			baserobot.execute(bw);
			assertTrue("forwardSideEffect",
					baseRefRobot.getGlobalPosition().x < 0);
		}
	}
	
	@Test
	public void testLeftMov() {
		if (baserobot instanceof ISimulatedWorldRef) {
			ISimulatedWorldRef baseRefRobot = (ISimulatedWorldRef) baserobot;
			BaseRobotLeft lft = new BaseRobotLeft(new BaseRobotSpeed(100));
			baserobot.execute(lft);
			assertTrue("forwardSideEffect",
					baseRefRobot.getGlobalPosition().y < 0);
		}
	}
	
	@Test
	public void testRightMov() {
		if (baserobot instanceof ISimulatedWorldRef) {
			ISimulatedWorldRef baseRefRobot = (ISimulatedWorldRef) baserobot;
			BaseRobotRight rgt = new BaseRobotRight(new BaseRobotSpeed(100));
			baserobot.execute(rgt);
			assertTrue("forwardSideEffect",
					baseRefRobot.getGlobalPosition().y > 0);
		}
	}
	
	//
	// @Test
	// public void testStringRep() {
	// String defStringRep =
	// defStringRep = defStringRep.replace("NAME", componentType.getName())
	// .replace("POS", position.getDefStringRep());
	// }
}
