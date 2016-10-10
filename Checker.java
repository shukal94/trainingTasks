package com.epam.training.tat.shukalovich.task06.checker;

import com.epam.training.tat.shukalovich.task06.rules.MoreThan5WordsRule;
import com.epam.training.tat.shukalovich.task06.rules.NonNumericRule;
import com.epam.training.tat.shukalovich.task06.rules.OnlyNumbersRule;
import com.epam.training.tat.shukalovich.task06.rules.WordFromDictionaryRule;

/** This class checks the user input on according to the following rules:
 * 1. String contains only numbers
 * 2. There are no numbers in the string
 * 3. User string contains more than 5 words
 * 4. User string is equals to a word from dictionary
 * @version 1.0
 */
public class Checker {
  /** Following method runs the checking user string on according to a rules
   * @param userStr - an user input string
   * @version 1.0
   */
  public void runChecking (String userStr) {
	  OnlyNumbersRule rule1 = new OnlyNumbersRule();
	  NonNumericRule rule2 = new NonNumericRule();
	  MoreThan5WordsRule rule3 = new MoreThan5WordsRule();
	  WordFromDictionaryRule rule4 = new WordFromDictionaryRule();
	    
	  System.out.println("A user string contains only numbers: " + rule1.checkRule(userStr));
	  System.out.println("A user string does not contain numbers: " + rule2.checkRule(userStr));
	  System.out.println("A user string contains more than 5 words: " + rule3.checkRule(userStr));
	  System.out.println("A user string contain a word from dictionary: " + rule4.checkRule(userStr));
  }
}
