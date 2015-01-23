package it.mtr.robotBase.mock;

import org.omg.CosNaming.IstringHelper;

import it.mrt.robotBase.interfaces.ISimulatedWorldRef;
import it.mtr.robotBase.utils.GlobalPosition;
import it.unibo.iot.executors.baseRobot.IBaseRobot;
import it.unibo.iot.models.commands.baseRobot.BaseRobotBackward;
import it.unibo.iot.models.commands.baseRobot.BaseRobotForward;
import it.unibo.iot.models.commands.baseRobot.BaseRobotLeft;
import it.unibo.iot.models.commands.baseRobot.BaseRobotRight;
import it.unibo.iot.models.commands.baseRobot.IBaseRobotCommand;
import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.robotComponent.configuration.IRobotComponentype;

public class MockBaseRobot implements IBaseRobot, ISimulatedWorldRef{

	GlobalPosition myPosition = new GlobalPosition();
	
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
		if(command instanceof BaseRobotForward) {
			myPosition.x += 0.1;
		}
		if(command instanceof BaseRobotBackward) {
			myPosition.x -= 0.1;
		}
		if(command instanceof BaseRobotLeft) {
			myPosition.y -= 0.1;
		}
		if(command instanceof BaseRobotRight) {
			myPosition.y += 0.1;
		}
	}

	@Override
	public GlobalPosition getGlobalPosition() {
		return myPosition;
	}
}
