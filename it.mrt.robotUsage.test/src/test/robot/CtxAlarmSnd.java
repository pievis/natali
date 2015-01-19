package test.robot;

import java.io.FileInputStream;
import java.io.InputStream;

import it.unibo.contactEvent.platform.EventPlatformKb;
import it.unibo.is.interfaces.IOutputView;
import it.unibo.qactors.ActorContext;

public class CtxAlarmSnd extends ActorContext {

	public CtxAlarmSnd(String name, IOutputView outView,
			InputStream sysKbStream, InputStream sysRulesStream)
			throws Exception {
		super(name, outView, sysKbStream, sysRulesStream);
	}

	@Override
	public void configure() {
		try{
			new AlarmSndActor("alarmsnd", this, outView);
		}catch(Exception e){
			println("Errore durante la configurazione di CtxAlarmSnd");
		}
		
	}

	/*
	 * ---------------------------------------------- MAIN
	 * ----------------------------------------------
	 */
	public static void main(String[] args) throws Exception {
		InputStream sysKbStream = new FileInputStream("robotplanned.pl");
		InputStream sysRulesStream = new FileInputStream("sysRules.pl");
		new CtxAlarmSnd("alarmsnd", EventPlatformKb.stdOutView, sysKbStream,
				sysRulesStream).configure();
	}
}
