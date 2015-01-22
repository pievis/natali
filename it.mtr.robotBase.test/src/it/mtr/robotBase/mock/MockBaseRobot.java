package it.mtr.robotBase.mock;

import org.omg.CosNaming.IstringHelper;

import it.unibo.iot.executors.baseRobot.IBaseRobot;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;
import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.robotComponent.configuration.IRobotComponentype;

public class MockBaseRobot implements IBaseRobot {

	boolean mockVar = false;
	
	@Override
	public IPosition getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRobotComponentype getComponentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefStringRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(IBaseRobotCommand command) {
		if(command instanceof IncBaseRobotCommandMock){
			((IncBaseRobotCommandMock) command).getCounter().inc();
		}
		mockVar = true;
	}
	
	public boolean getMockVar() {
		return mockVar;
	}

}
