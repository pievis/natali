package test.robot;

import it.unibo.contactEvent.interfaces.IContactEventPlatform;
import it.unibo.contactEvent.platform.ContactEventPlatform;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;
import it.unibo.qactors.QActor;
import it.unibo.robotUsage.intro.RobotSysKb;

public class AlarmSndActor extends QActor {

	long waitMillis = 500;
	
	public AlarmSndActor(String actorId, ActorContext myCtx, IOutputView outView) {
		super(actorId, myCtx, outView);
	}

	@Override
	protected void doJob() throws Exception {
		println("Sending...");
		Thread.sleep(waitMillis);
		try{
//			sendMsg("cmd", "robot1", ActorContext.dispatch, RobotSysKb.halt);
			sendMsg("cmd", "robot1", ActorContext.dispatch, RobotSysKb.BACKWARD.getDefStringRep());
			sendMsg("cmd", "robot1", ActorContext.dispatch, RobotSysKb.FORWARD.getDefStringRep());
			sendMsg("cmd", "robot1", ActorContext.dispatch, RobotSysKb.STOP.getDefStringRep());
		}catch(Exception e){
			println("Errore invio " + e.getMessage());
		}
		//Invia alert alarm
		println("Messaggio di allarme inviato");
		//Thread.sleep(1000);
		println("Test con eventi");
		
		try{
			IContactEventPlatform pl = ContactEventPlatform.getPlatform();
			pl.raiseEvent(this.getName(), "usercmd", "usercmd");
		}catch(Exception e){
			println("Errore invio " + e.getMessage());
		}
		println("Evento di allarme inviato");
	}

}
