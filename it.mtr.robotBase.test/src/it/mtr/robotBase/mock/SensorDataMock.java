package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.Position;
import it.unibo.iot.models.sensorData.PositionValue;
import it.unibo.iot.models.sensorData.SensorType;

public class SensorDataMock implements ISensorData {

	@Override
	public String getName() {
		return "mockdata";
	}

	@Override
	public String getDefStringRep() {
		return getName()+"(data)";
	}

	@Override
	public IPosition getPosition() {
		return new Position(PositionValue.FRONT);
	}

	@Override
	public SensorType getType() {
		return SensorType.DISTANCE;
	}

}
