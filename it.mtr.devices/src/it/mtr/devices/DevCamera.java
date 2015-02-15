package it.mtr.devices;

import it.mtr.devices.interfaces.IDevCamera;
import it.mtr.devices.interfaces.IDevCameraImpl;
import it.unibo.is.interfaces.IObserver;
import it.unibo.system.SituatedPlainObject;

public class DevCamera extends SituatedPlainObject implements IDevCamera {

	IDevCameraImpl camera;
	
	public void setImpl(IDevCameraImpl impl){
		camera = impl;
	}
	
	@Override
	public void getImage() {
		camera.getImage();
	}

	@Override
	public String getDefaultRep() {
		return camera.getDefaultRep();
	}

}
