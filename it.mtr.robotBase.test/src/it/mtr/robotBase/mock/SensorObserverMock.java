package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.robotUsage.naive.SensorObserver;

public class SensorObserverMock extends SensorObserver<ISensorData> {

	private ISensorData data;
	
	public SensorObserverMock() {
		super(null);
	}
	
	@Override
	public void notify(ISensorData data) {
		super.notify(data);
	}
	
	public ISensorData getCurVal(){
		return data;
	}
}
