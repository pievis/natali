package it.mtr.robotBase.test;

import static org.junit.Assert.*;
import it.mtr.robotBase.mock.SensorDataMock;
import it.mtr.robotBase.mock.SensorMock;
import it.mtr.robotBase.mock.SensorObserverMock;
import it.unibo.iot.models.sensorData.IPosition;
import it.unibo.iot.models.sensorData.ISensorData;
import it.unibo.iot.models.sensorData.Position;
import it.unibo.iot.models.sensorData.PositionValue;
import it.unibo.iot.models.sensorData.SensorType;
import it.unibo.iot.sensor.ILogicalSensor;
import it.unibo.iot.sensor.ISensor;
import it.unibo.iot.sensor.ISensorDevice;
import it.unibo.iot.sensor.ISensorObservable;
import it.unibo.iot.sensor.Sensor;

import org.junit.Before;
import org.junit.Test;

public class TestSensor {

	private ISensor<ISensorData> sensor;
	private ILogicalSensor<ISensorData> logicalSensor;

	@Before
	public void setup() {
		IPosition position = new Position(PositionValue.FRONT);
		sensor = new SensorMock(position, SensorType.DISTANCE);
		logicalSensor = (ILogicalSensor<ISensorData>) sensor;
	}

	@Test
	public void testSensorData() {
		ISensorData data = new SensorDataMock("testData");
		assertNotNull(data);
		logicalSensor.setData(data);
		String str1 = sensor.getData().getDefStringRep();
		String str2 = data.getDefStringRep();
		assertTrue("getTest", str1.equals(str2));
	}

	@Test
	public void testObserver() {
		SensorObserverMock observer = new SensorObserverMock();
		SensorDataMock data = new SensorDataMock("test");
		sensor.addObserver(observer);
		logicalSensor.setData(data);
		String str1 = observer.getData().getDefStringRep();
		String str2 = data.getDefStringRep();
		assertTrue("observerTest", str1.equals(str2));
	}

	@Test
	public void testSensorRep() {
		String expRep = sensor.getComponentType().getName().toLowerCase() + "."
				+ sensor.getPosition().getDefStringRep();
		assertTrue("expectedStrTest", expRep.equals(sensor.getDefStringRep()));
	}
}
