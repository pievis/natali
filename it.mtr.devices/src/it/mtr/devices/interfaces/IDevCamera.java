package it.mtr.devices.interfaces;

import it.unibo.buttonLed.interfaces.IDeviceInput;

public interface IDevCamera extends IDeviceInput{
	void getImage();
	void setImpl(IDevCameraImpl impl);
}
