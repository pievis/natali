package it.mtr.robotBase.mock;

import it.mtr.robotBase.utils.Counter;

public class IncBaseRobotCommandMock extends BaseRobotCommandMock {

	Counter counter;

	public IncBaseRobotCommandMock(Counter c) {
		counter = c;
	}

	public Counter getCounter() {
		return counter;
	}
}
