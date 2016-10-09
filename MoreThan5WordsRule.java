package com.epam.training.tat.shukalovich.task06.rules;

/** Class-rule that realize checking the user input is contain only more than 5 words
 * @version 1.0
 */
public class MoreThan5WordsRule extends Rule {
	/** Method that checks the user input on containing more than 5 words
	 *  @param userInput - a string, that user inputs
	 *  @return logical value, true or false in dependence of the input string
	 */
	public boolean checkRule(String userInput) { 
	  return (userInput.split(" +").length > 5);
	}
}
