package it.mtr.robotBase.mock;

import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.robotUsage.naive.SensorObserver;

public class MockSensorObserver extends SensorObserver<ISensorData> {

	boolean received=false;
	public MockSensorObserver(IOutputView outView) {
		super(outView);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void notify(ISensorData data) {
		
		received = true;
	}

}
