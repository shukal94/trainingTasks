package com.epam.training.tat.shukalovich.task08.commands;

import com.epam.training.tat.shukalovich.task08.interfaces.Executable;

/** This class defines a behavior of the application,
 * when user types "exit"
 * @version 1.0
 */
public class ExitCommand implements Executable {
  /** Constructor for validating user input,   
   * and setting up value of this input
   * @param userInput - a string, that user types
   */
  public ExitCommand(String[] userInput) {
	if (!userInput.equals("exit")) {
	  System.exit(0);
	}
  }
  
  /** This method realizes a logic of behavior of the program,
   * when user types "exit"
   */
  @Override
  public void execute() {
	// TODO Auto-generated method stub
  }
}

