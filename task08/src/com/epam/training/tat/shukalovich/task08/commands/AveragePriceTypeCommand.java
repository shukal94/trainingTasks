package com.epam.training.tat.shukalovich.task08.commands;

import com.epam.training.tat.shukalovich.task08.interfaces.Executable;

/** This class defines a behavior of the application,
 * when user counts "average price"
 * @version 1.0
 */
public class AveragePriceTypeCommand implements Executable {
  /** Constructor for validating user input,   
   * and setting up value of this input
   * @param userInput - a string, that user types
   */
  public AveragePriceTypeCommand(String[] userInput) {
	if (!userInput.equals("average price")) {//////////////**Поебень*/
	  System.exit(0);
	}
  }
  
  /** This method realizes a logic of behavior of the program,
   * when user types "average price type"
   */
  @Override
  public void execute() {
	// TODO Auto-generated method stub
  }
}
