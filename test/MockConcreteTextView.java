import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import script.ImageTextView;

/**
 * This class represents a text-based mock view used to handle a script.
 */
public class MockConcreteTextView implements ImageTextView {
  private Scanner input;
  private final StringBuilder log;

  /**
   * Constructor only created to pass in the StreamBuilder.
   *
   * @param log the model to use
   */
  public MockConcreteTextView(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void openScript(Scanner input) {
    this.input = input;
    log.append("View: setting the scanner in the view");
    log.append((System.lineSeparator()));
  }

  @Override
  public List<String> readCommand() {
    String line = input.nextLine();
    List<String> list = new ArrayList<>();
    int index = line.indexOf(' ');
    if (index == -1) {
      list.add(line);
    } else {
      list.add(line.substring(0, index));   //(command only)
      list.add(line.substring(index + 1));  //(arguments only)
    }
    log.append("View: read command from the scanner");
    log.append((System.lineSeparator()));
    return list;

  }

  @Override
  public boolean hasNextCommand() {
    log.append("View: is there another command to read from scanner");
    log.append((System.lineSeparator()));
    return input.hasNextLine();
  }
}
