package com.epam.training.tat.shukalovich.task06.runner;

import com.epam.training.tat.shukalovich.task06.rules.*;
import java.util.Scanner;

/** An enter point to the application. This class realizes the business logic, such as
 * analyze the user input on according to a rules and giving an outcome of analysis to user
 * @version 1.0
 */
public class Runner {
  /** Method analyzes user input on according to a rules, such as user string contains:
   *  1. Only numbers
   *  2. There are no numbers in the string
   *  3. User string contains more than 5 words
   *  4. User string is equals to a word from dictionary
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String userStr = scan.nextLine();
    
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
