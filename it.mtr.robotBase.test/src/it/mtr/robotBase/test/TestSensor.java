package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.SensorMock;
import it.mtr.robotBase.mock.SensorObserverMock;
import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.Position;
import it.unibo.iot.models.sensorData.PositionValue;
import it.unibo.iot.models.sensorData.SensorType;
import it.unibo.iot.sensor.ISensor;
import it.unibo.iot.sensor.ISensorDevice;
import it.unibo.iot.sensor.ISensorObservable;
import it.unibo.iot.sensor.Sensor;

import org.junit.Before;
import org.junit.Test;

public class TestSensor {

	private ISensor<ISensorData> sensor;

	@Before
	public void setup() {
		IPosition position = new Position(PositionValue.FRONT);
		sensor = new SensorMock(position, SensorType.DISTANCE);
	}

	@Test
	public void testSensorData() {
		ISensorData data = sensor.getData();
		assertNotNull(data);
	}

	@Test
	public void testObserver() {
		ISensorObservable<ISensorData> observer; 
	}

	@Test
	public void testSensorRep() {
		String expRep = sensor.getComponentType().getName().toLowerCase() + "."
				+ sensor.getPosition().getDefStringRep();
		assertTrue("expectedStrTest", expRep.equals(sensor.getDefStringRep()));
	}
}
