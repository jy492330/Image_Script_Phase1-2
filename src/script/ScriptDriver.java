package script;

import images.ConcreteImageModel;
import images.ImageModel;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the driver of the program to handle file input errors and run script.
 */
public class ScriptDriver {

  /**
   * This is the main program to run the image script.
   * @param args   arguments of the main method.
   */
  public static void main(String[] args) {
    String fileName = "";
    if (args.length == 0) {
      System.out.println("You need to pass in the file path of the script to be processed");
      Scanner scanner = new Scanner(System.in);
      while (fileName.length() == 0) {
        System.out.println("Please enter the name of the file:\n");
        fileName = scanner.nextLine();
      }
      scanner.close();
    } else {
      fileName = args[0];
      if (args.length > 1) { // if user gives multiple file names // should read up to two words
        System.out.println("Only the first file name input will be processed.");
      }
    }
    try {
      File file = new File("res/" + fileName);
      if (!file.exists()) {
        file = new File(fileName); // default to the working directory
      }
      Readable fileReader = new FileReader(file);
      Scanner scanner = new Scanner(fileReader);
      ImageTextView view = new ConcreteTextView();
      view.openScript(scanner);
      ImageModel model = new ConcreteImageModel();
      new ConcreteTextController(model, view);
      scanner.close();
    } catch (IOException ex) {
      System.out.println("Unable to open the file: " + fileName);
    }
    // check file not found ioException:
  }

}
