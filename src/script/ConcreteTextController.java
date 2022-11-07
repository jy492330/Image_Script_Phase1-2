package script;

import images.ImageModel;
import java.util.List;

/**
 * This class represents a controller used to handle a script and any errors
 * found in a script file provided by the user.
 */
public class ConcreteTextController {

  //  private ImageModel model;
  //  private ImageTextView view;
  // No need to use fields here if no methods are defined for the controller class

  /**
   * Constructor.
   *
   * @param model the model to use
   * @param view the view to use
   */
  public ConcreteTextController(ImageModel model, ImageTextView view) {
    boolean imageLoaded = false;
    int lineNum = 0; // accumulator to print the command line where the error occurs
    while (view.hasNextCommand()) { // while there's line in the script to be processed
      List<String> command = view.readCommand();  // to get the next command
      lineNum++;
      switch (command.get(0)) {
        case "load":
          if (command.size() == 2) {
            try {
              model.loadImage(command.get(1)); // index 1 is the file name
              imageLoaded = true;
            } catch (IllegalArgumentException ex) {
              // don't have permission because file name doesn't exit
              printError(ex.getMessage(), lineNum);
              // Error message: "Something went wrong reading the image file."
            }
          } else {
            printError("Load requires a file name", lineNum);
          }
          break;

        case "save":
          if (command.size() == 2) {
            if (imageLoaded) {
              try {
                model.saveImage(command.get(1)); //
              } catch (IllegalArgumentException ex) {
                printError(ex.getMessage(), lineNum);
              }  // will throw "Error occurred writing the data to the file"
            } else {
              printError("Save requires an image to be loaded", lineNum);
            }  // will trigger printError if image is saved before load.
          } else {
            printError("Save requires a file name", lineNum);
          }  // will throw printError when command size is 1 instead of 2.
          break;

        case "blur":
          if (command.size() == 1) {
            if (imageLoaded) {
              model.applyBlur(); // index 1 is file name
            } else {
              printError("Blur requires an image to be loaded", lineNum);
            }
          } else {
            printError("Blur must be a line by itself.", lineNum);
          }
          break;

        case "sharpen":
          if (command.size() == 1) {
            if (imageLoaded) {
              model.applySharpen();
            } else {
              printError("Sharpen requires an image to be loaded", lineNum);
            }
          } else {
            printError("Sharpen must be a line by itself.", lineNum);
          }
          break;

        case "grayscale":
          if (command.size() == 1) {
            if (imageLoaded) {
              model.applyGrayscale();
            } else {
              printError("Grayscale requires an image to be loaded.", lineNum);
            }
          } else {
            printError("Grayscale must be a line by itself.", lineNum);
          }
          break;

        case "sepia":
          if (command.size() == 1) {
            if (imageLoaded) {
              model.applySepia();
            } else {
              printError("Sepia requires an image to be loaded.", lineNum);
            }
          } else {
            printError("Sepia must be a line by itself.", lineNum);
          }
          break;

        case "dither":
          if (command.size() == 1) {
            if (imageLoaded) {
              model.applyDither();
            } else {
              printError("Dither requires an image to be loaded.", lineNum);
            }
          } else {
            printError("Dither must be a line by itself.", lineNum);
          }
          break;

        case "mosaic":
          if (command.size() == 2) {
            if (imageLoaded) {
              printError("Mosaic is not implemented until assignment 9 is given.", lineNum);
            // model.applyMosaic(command.get(1)); // index 1 is the file name
            } else {
              printError("Mosaic requires an image to be loaded.", lineNum);
            }
          } else {
            printError("Mosaic requires a seed argument.", lineNum);
          }
          break;

        case "":    // ignores the blank line as an empty string in the script
          break;    // Make sure there's no space in the blank line

        default:    // if it doesn't match any cases listed above
          printError("Invalid command: " + command.get(0), lineNum);
      }
    }
  }

  private void printError(String msg, int lineNum) {
    System.out.println("An error has occurred on line " + lineNum + ": " + msg);
  }
}
