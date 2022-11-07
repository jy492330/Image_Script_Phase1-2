package script;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a text-based view used to handle a script.
 */
public class ConcreteTextView implements ImageTextView {
  private Scanner input;

  @Override
  public void openScript(Scanner input) {
    this.input = input;
  }

  @Override
  public List<String> readCommand() {
    String line = input.nextLine(); // Reads the next line from the script file
    List<String> list = new ArrayList<>();
    int index = line.indexOf(' '); // if there's no space, sets index to -1.
    // If there's a space, sets index to the index location of the space in string.

    if (index == -1) {  // only one word because space is not found
      list.add(line);  // add this line which is a one word string to the list
    } else {
      // when there's more than 1 word, it adds the 1st wrd up to but not including space
      list.add(line.substring(0, index));   //(command only)
      // adds multiple words after the command which can contain spaces to the list
      list.add(line.substring(index + 1));  //(arguments only)
    }
    return list; // e.g. [blur, city line-blurred.png]
  }

  @Override
  public boolean hasNextCommand() {
    return input.hasNextLine(); // returns true if there's another line available to be read from
    // the scanner that reads the line from the script.
  }
}