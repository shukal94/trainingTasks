package com.epam.training.tat.shukalovich.task08.commands;

import com.epam.training.tat.shukalovich.task08.interfaces.Executable;

/** This class defines a behavior of the application,
 * when user counts "count all"
 * @version 1.0
 */
public class CountAllCommand implements Executable {
  /** Constructor for validating user input,   
   * and setting up value of this input
   * @param userInput - 
   */
  public CountAllCommand(String[] userInput) {
	if (!userInput.equals("count all")) {
	  System.exit(0);
	}
  }
  
  /** This method realizes a logic of behavior of the program,
   * when user types "count all"
   */
  @Override
  public void execute() {
	// TODO Auto-generated method stub
  }
}
