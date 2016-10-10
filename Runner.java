package com.epam.training.tat.shukalovich.task06.runner;

import com.epam.training.tat.shukalovich.task06.rules.*;
import java.util.Scanner;

/** An enter point to the application. This class realizes the 
 * an input of a user string.
 * @version 1.0
 */
public class Runner {
  /** This method opens the stream for input a string by a console and runs the checking
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String userStr = scan.nextLine();
    
    Checker check = new Checker();
    
    check.runChecking(userStr);
  }

}
