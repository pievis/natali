package it.unibo.robotAreaSystem;

import it.unibo.contactEvent.interfaces.IEventItem;
import it.unibo.contactEvent.platform.EventHandlerComponent;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;
import it.unibo.robotActor.interpreted.action.IActionHandler;

public class PhotoHandler extends EventHandlerComponent implements IActionHandler{
	public PhotoHandler(String name, ActorContext ctx, String[] eventIds, IOutputView view ) throws Exception {
		super(name, ctx, eventIds, view);
  	}
	@Override
	public void doJob() throws Exception {
		IEventItem event = getEventItem();
		String msg = getName() + ":" + event.getEventId() + " msg=" + event.getMsg() + " emitter=" + event.getSubj()   ;
		showMsg( "--------------------------------------------------" );	
		showMsg( msg );				 
		showMsg( "--------------------------------------------------" );	
	}	
	
	public String getHandlerName(){
		return getName();
	}
	public void addEventId(String eventId){
		//if not already registred ...
		evPlatform.registerForEvent(getName(), eventId);
	}	
}