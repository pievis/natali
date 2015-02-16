package it.mtr.devices.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import it.mtr.devices.interfaces.IDevCameraLinux;

public class DevCameraLinux extends DevCameraImpl implements IDevCameraLinux {

	String storingPath;
	int shootCount = 0;

	public DevCameraLinux(String cameraName, String storingPath) {
		super(cameraName);
		this.storingPath = storingPath;
	}

	@Override
	public void getImage() {
		String command = "streamer -f jpeg -o image" + shootCount + ".jpeg";

		Process p; //create the runtime enviroment
		try {
			p = Runtime.getRuntime().exec(command); //execute the command
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream())); //read the shell

			String line = "";
			while ((line = reader.readLine()) != null) {
				println(line); //and print it into the standard out
			}
			shootCount++;
		} catch (Exception e) {

		}

	}

	@Override
	public String getDefaultRep() {
		return "camera("+getName()+","+storingPath+")";
	}

}
