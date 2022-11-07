package script;

import java.util.List;
import java.util.Scanner;

/**
 * A ImageView representation that reads the script and generate the output files.
 */
public interface ImageTextView {

  /**
   * Method to receive the path of the script file and open the file.
   *
   * @param input input from the StringBuilder
   */
  public void openScript(Scanner input); // use scanner to parse the file to be read

  /**
   * Method to read the next command line from the script file.
   *
   * @return a list of String type commands and arguments
   */
  public List<String> readCommand();

  /**
   * Return true if there's another command to read, read false if it's at the end of the script.
   * Otherwise, return false.
   *
   * @return a boolean value true or false
   */
  public boolean hasNextCommand();

}
