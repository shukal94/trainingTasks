package com.epam.training.tat.shukalovich.task06.rules;

/** An abstract class, that setting behavior of extended rules
 * @version 1.0
 */
public abstract class Rule {
  
  /** Abstract method for checking the user input string 
   *  for according to the some rule
   *  @param userInput - a string, that user inputs
   *  @return isAccordingTo - logical value, true or false in dependence of input string
   */
  public boolean checkRule(String userInput) {
    return true;
  }
}
