package org.rossedth.adaptable_fsm;

import java.io.IOException;
import java.util.Scanner;
import org.jeasy.states.api.FiniteStateMachineException;


/**
 * 
 * This tutorial is an implementation as proof of concept of the Holistic Model for adaptivity developed as part of a PhD project at EPUSP
 * @author Rosalia Edith Caya Carhuanina (rosalia.caya@usp.br)
 * 
 */

class App {

	public static void main(String[] args) throws FiniteStateMachineException, IOException {


		/*
		 * Create a RecognizerFSM instance
		 */
		RecognizerFSM recognizer=new RecognizerFSM();
		
		/*
		 * Setup GraphViz
		 */
	
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.setup_graph();

        /*
         * Create a AListener instance
         */

    	AListener monitor=new AListener();
    	monitor.setSys_U(recognizer);
    	
    	
    	/*
		 * Fire some events and print FSM state
		 */


    	recognizer.printCurrentState(gv);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert an input or Press [q] to quit tutorial.");
		System.out.println("=================================================");

		while (true) {
			String input = scanner.nextLine();

			recognizer.processInput(input);
			recognizer.printCurrentState(gv);

			if (recognizer.atFinalState()) {
				System.out.println("Recognizer has reach final state ");   
				System.exit(0);
				scanner.close();                
			}

			if (input.trim().equalsIgnoreCase("q")) {
				System.out.println("input = " + input.trim());
				System.out.println("Bye!");
				System.exit(0);
				scanner.close();
			}         

		}

	} 

}