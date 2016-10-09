package com.epam.training.tat.shukalovich.task06.rules;

/** Class-rule that realize checking the user input is contain only numbers
 * @version 1.0
 */
public class OnlyNumbersRule extends Rule {
  /** Method that checks the user input on containing the numbers
   *  @param userInput - a string, that user inputs
   *  @return logical value, true or false in dependence of the input string
   */
  public boolean checkRule(String userInput) { 
    return userInput.matches("[0-9]+");
  }
}
