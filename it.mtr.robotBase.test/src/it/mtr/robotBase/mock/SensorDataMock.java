package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.Position;
import it.unibo.iot.models.sensorData.PositionValue;
import it.unibo.iot.models.sensorData.SensorType;

public class SensorDataMock implements ISensorData {

	@Override
	public String getName() {
		return "sensor(mock)";
	}

	@Override
	public String getDefStringRep() {
		return "sensor(mock,value)";
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
