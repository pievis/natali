package it.mtr.devices.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.mtr.devices.interfaces.IDevCameraImpl;
import it.mtr.devices.interfaces.IDevCameraPievis;

public class DevCameraPievis extends DevCameraImpl implements IDevCameraPievis{
	String storingPath;
	int shoots = 0;
	
	public DevCameraPievis(String cameraName, String storingPath) {
		super(cameraName);
		this.storingPath = storingPath;
	}
	
	@Override
	public String getDefaultRep() {
		return "camera("+getName()+","+storingPath+")";
	}
	
	public void setStoringPath(String storingPath){
		this.storingPath = storingPath;
	}

	@Override
	public void getImage() {
		String command = "CommandCam /filename "+storingPath+"out"+shoots+".png"; //funziona solo sul mio pc
		
		//Usa il runtime
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			//for the output on console
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        String line = "";			
	        while ((line = reader.readLine())!= null) {
	        	println(line);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		shoots++;
	}
	
}
