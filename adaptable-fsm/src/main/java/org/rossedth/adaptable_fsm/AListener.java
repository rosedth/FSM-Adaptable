package org.rossedth.adaptable_fsm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jeasy.states.api.AbstractEvent;

public class AListener {
	private RecognizerFSM sys_U;
	
	public AListener() {		
	}
	
	public void setSys_U(RecognizerFSM recognizer) {
		this.sys_U=recognizer;
		sys_U.setListener(new RecognizerFSM.IListener() {
			
			@Override
			public void onInvalidEntry(AbstractEvent event) {
				System.out.println("Invalid input for current state "+ sys_U.getFSM().getCurrentState().getName() +" from Listener");
			}
			
			@Override
			public void onUnidentifiedEntry(AbstractEvent event) {
				System.out.println("Unidentified input " +event.getName()+" detected at state "+ sys_U.getFSM().getCurrentState().getName()+" reported from Listener");
				if (event.getName().equalsIgnoreCase("K")) {
					int delay=5000;
					onTimer(delay);
				}
			}
			
			public void onTimer(final int delay) {
				Timer timer=sys_U.getTimer();
				if (timer==null){
					timer=new Timer(delay,null);
					sys_U.setTimer(timer);
				}
				timer.setDelay(delay);
				timer.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
				    	System.out.println(delay+" seconds have passed since K was detected as input");
				    	sys_U.getTimer().stop();
				    }
				});
				
				timer.start();
			}
		});
	}
	
}
