package it.mtr.robotBase.mock;

import it.unibo.iot.models.commands.baseRobot.IBaseRobotAngle;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotSpeed;

public class BaseRobotCommandMock implements IBaseRobotCommand {

	@Override
	public IBaseRobotSpeed getSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBaseRobotAngle getAngle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefStringRep() {
		// TODO Auto-generated method stub
		return "MockCommand";
	}

}
