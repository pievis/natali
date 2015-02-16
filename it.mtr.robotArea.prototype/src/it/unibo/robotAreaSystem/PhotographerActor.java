package it.unibo.robotAreaSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import alice.tuprolog.Term;
import it.mtr.devices.DevCamera;
import it.mtr.devices.impl.DevCameraPievis;
import it.mtr.devices.interfaces.IDevCamera;
import it.mtr.devices.interfaces.IDevCameraImpl;
import it.unibo.contactEvent.interfaces.IActorMessage;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;
import it.unibo.qactors.QActor;
import it.unibo.qactors.QActorMessage;

public class PhotographerActor extends QActor {
	
//	int photoCount = 0;
	IDevCamera camera;

	public PhotographerActor(String actorId, ActorContext myCtx,
			IOutputView outView) {
		super(actorId, myCtx, outView);
		IDevCameraImpl camImpl = new DevCameraPievis("cam0", "");
		camera = new DevCamera();
		camera.setImpl(camImpl);
	}
	
	@Override
	protected void doJob() throws Exception {
		//Aspetta un messaggio, esegui una foto e manda un answer
		while(true){
			try{
				String msg = receiveMsg();
//				msg(askphoto,request,robotactor,photographeractor,'doAction(takephoto,localhost)',1)
				IActorMessage m = new QActorMessage(msg);
				msg = m.msgContent();
				println(getName() + " received:" + msg);
				//elaborate the msg
				String mTxt = msg.split("'doAction\\(")[1];
				String action = mTxt.split(",")[0];
				String dest = mTxt.split(",")[1].replace(")'", "");
				doAction(action, dest);
				println("action: " + action + " dest: " + dest);
				//send a reply
				sendMsg("askphoto", "assistant", ActorContext.answer, "ok");
				println("Msg inviato: ok");
//				photoCount++;
			}catch(Exception e){
				e.printStackTrace();
				sendMsg("askphoto", "assistant", ActorContext.answer, "error");
				println("Errore nell'eseguire la foto");
			}
		}
	}
	
	void doAction(String action, String arg) throws IOException, InterruptedException{
		action = action.toLowerCase();
		if(action.equals("takephoto")){
//			takePhoto(arg);
			camera.getImage();
			return;
		}
		println("Can't execute action " + action);
	}
	
	/**
	 * Mock function to take a photo
	 * @param destination specifies the destination machine ip for the photo
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
//	void takePhoto(String destination) throws IOException, InterruptedException{
//		
//		String command = "CommandCam /filename out"+photoCount+".png"; //funziona solo sul mio pc
//		
//		//Usa il runtime
//		Process p = Runtime.getRuntime().exec(command);
//		p.waitFor();
//		//for the output on console
//		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//        String line = "";			
//        while ((line = reader.readLine())!= null) {
//        	println(line);
//        }
//	}

}
