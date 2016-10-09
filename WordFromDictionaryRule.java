package com.epam.training.tat.shukalovich.task06.rules;

/** Class-rule that realize checking the user input is contain the word from dictionary
 * @version 1.0
 */
public class WordFromDictionaryRule extends Rule {	
  /**Field that defines a dictionary*/
  private String dictionaryWord = "regexes_are_cool";
  
  /** Method that checks the user input on containing the word from dictionary
   *  @param userInput - a string, that user inputs
   *  @return logical value, true or false in dependence of the input string
   */
  public boolean checkRule(String userInput) { 
    return (userInput.equals(dictionaryWord));
  }
}
