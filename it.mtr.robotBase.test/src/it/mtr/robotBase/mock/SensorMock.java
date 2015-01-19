package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.SensorType;
import it.unibo.iot.sensor.ISensor;
import it.unibo.iot.sensor.Sensor;

public class SensorMock extends Sensor {

	public SensorMock(IPosition position, SensorType type) {
		super(position, type);
	}

	@Override
	public SensorDataMock getData() {
		return new SensorDataMock();
	}
}
