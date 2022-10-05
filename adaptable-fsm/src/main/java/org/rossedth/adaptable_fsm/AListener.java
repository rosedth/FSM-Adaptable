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
		sys_U.setInvalidEntryListener(new RecognizerFSM.InvalidEntryListener() {
			
			@Override
			public void onInvalidEntry(AbstractEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Invalid input for current state "+ sys_U.getFSM().getCurrentState().getName() +" from Listener");				
			}
		});
		
		sys_U.setUndefinedEntryListener(new RecognizerFSM.UndefinedEntryListener() {
			
			@Override
			public void onUnidentifiedEntry(AbstractEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Unidentified input " +event.getName()+" detected at state "+ sys_U.getFSM().getCurrentState().getName()+" reported from Listener");
				if (event.getName().equalsIgnoreCase("K")) {
					int delay=5000;
					sys_U.getTimerListener().onTimer(delay);
					//onTimer(delay);
				}				
			}
		});
		
		sys_U.setTimerListener(new RecognizerFSM.TimerListener() {
			
			@Override
			public void onTimer(int delay) {
				// TODO Auto-generated method stub
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
