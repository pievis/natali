package it.unibo.robotAreaSystem;

import it.unibo.contactEvent.interfaces.IContactEventPlatform;
import it.unibo.contactEvent.platform.ContactEventPlatform;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;
import it.unibo.qactors.QActor;
import it.unibo.qactors.SenderObject;
import it.unibo.robotActor.interpreted.IRobotActor;
import it.unibo.robotActor.interpreted.action.IAsynchAction;
import it.unibo.robotActor.utils.RobotSysKb;

public class AskForPhoto extends AskForPhotoSupport {

	QActor assistant;
	ActorContext actx;
	IContactEventPlatform platform;
	
	public AskForPhoto(String name, boolean cancompensate, String terminationEvId, String answerEvId,
			IOutputView outView, long maxduration) throws Exception {
		super(name, cancompensate, terminationEvId, answerEvId, outView, maxduration);
//		rActor = (QActor) RobotSysKb.getRobotActor(); //get robotActor
		
		actx = RobotSysKb.robotActorCtx;
		assistant = new QActor("assistant", actx, this.outView) {
			
			@Override
			protected void doJob() throws Exception {
				println(getName() + " started...");
			}
		};
		
//		rActor = MainRobotMessageDispatcherCtx.getPhotoAssistant();
//		platform = ContactEventPlatform.getPlatform();
   	}
	
	@Override
	protected String actionBody() throws Exception {
		
		long execTime = this.maxduration ;// tempo massimo di esecuzione
		String dest = this.arg;
		this.println("AskForPhoto Action  arg=" + dest +" execTime=" + execTime);
		this.println("INVIO DELLA RICHIESTA takePhoto");
//		platform.raiseEvent(getName(), "takePhoto", dest);
//		this.println("INVIO EseGuITO");
		
//		Invia una richiesta e aspetta una risposta
		assistant.sendMsg("askphoto", "photographeractor", ActorContext.request, "doAction(takephoto," + dest + ")");
		//suspended if no reply?
		this.println("In attesa di una risposta dal photographer");
		String reply = assistant.receiveMsg();
		println("AskForPhoto] " + reply);
		if(reply.startsWith("error")){
			println("Non è stato possibile scattare la foto");
		}
		return null;
	}
	
	@Override
	public void suspendAction() {
		println("AskForPhoto was suspended");
		super.suspendAction();
	}
}
