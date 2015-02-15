package it.mtr.devices.impl;

import it.mtr.devices.interfaces.IDevCameraImpl;
import it.unibo.system.SituatedPlainObject;

public abstract class DevCameraImpl extends SituatedPlainObject implements IDevCameraImpl{

	public DevCameraImpl(String cameraName) {
		super(cameraName);
	}

}
