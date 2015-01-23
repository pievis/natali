package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.SensorType;
import it.unibo.iot.sensor.ISensor;
import it.unibo.iot.sensor.Sensor;

public class SensorMock extends Sensor<ISensorData> {

	ISensorData data;
	
	public SensorMock(IPosition position, SensorType type) {
		super(position, type);
		data = new SensorDataMock();
	}
	
	@Override
	public ISensorData getData() {
		return data;
	}
	
	@Override
	public void setData(ISensorData data) {
		this.data = data;
		notifyAllObservers(data);
	}
	
}
