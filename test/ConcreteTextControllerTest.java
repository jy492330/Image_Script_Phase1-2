import static org.junit.Assert.assertEquals;

import images.ImageModel;
import java.util.Scanner;
import org.junit.Test;
import script.ConcreteTextController;
import script.ImageTextView;

/**
 * Test cases for the image text controller, using model and view mocks to independently test
 * the controller.
 */
public class ConcreteTextControllerTest {

  /** Testing Blur. */
  @Test
  public void testBlur() {
    StringBuilder input = new StringBuilder();
    //passes in strings from 3 method calls to the StreamBuilder
    input.append("load brisbane city.png").append(System.lineSeparator());
    //passes in strings from 2 method calls to the StreamBuilder
    input.append("blur").append(System.lineSeparator());
    //passes in strings from 2 method calls to the StreamBuilder
    input.append("blur").append(System.lineSeparator());
    //passes in strings from 2 method calls to the StreamBuilder
    input.append("save brisbane city-blurred2.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: blur"
        + System.lineSeparator() + "Model: blur" + System.lineSeparator() + "Model: save image"
        + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  /** Testing Sharpen. */
  @Test
  public void testSharpen() {
    StringBuilder input = new StringBuilder();
    input.append("load brisbane city.png").append(System.lineSeparator());
    input.append("sharpen").append(System.lineSeparator());
    input.append("save brisbane city-sharpen.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: sharpen"
        + System.lineSeparator() + "Model: save image" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  /** Testing Grayscale. */
  @Test
  public void testGrayscale() {
    StringBuilder input = new StringBuilder();
    input.append("load brisbane city.png").append(System.lineSeparator());
    input.append("grayscale").append(System.lineSeparator());
    input.append("save brisbane city-grayscale.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: grayscale"
        + System.lineSeparator() + "Model: save image" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  /** Testing Sepia. */
  @Test
  public void testSepia() {
    StringBuilder input = new StringBuilder();
    input.append("load brisbane city.png").append(System.lineSeparator());
    input.append("sepia").append(System.lineSeparator());
    input.append("save brisbane city-sepia.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: sepia"
        + System.lineSeparator() + "Model: save image" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  /** Testing Dither. */
  @Test
  public void testDither() {
    StringBuilder input = new StringBuilder();
    input.append("load brisbane city.png").append(System.lineSeparator());
    input.append("dither").append(System.lineSeparator());
    input.append("save brisbane city-dither.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: dither"
        + System.lineSeparator() + "Model: save image" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  /** Testing Dither and Sepia. */
  @Test
  public void testDitherSepia() {
    StringBuilder input = new StringBuilder();
    input.append("load brisbane city.png").append(System.lineSeparator());
    input.append("dither").append(System.lineSeparator());
    input.append("sepia").append(System.lineSeparator());
    input.append("save brisbane city-dither.png").append(System.lineSeparator());
    Scanner scanner = new Scanner(input.toString());
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new MockConcreteTextModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    ImageTextView view = new MockConcreteTextView(viewLog);
    view.openScript(scanner); // first call for the view log only occur once.
    new ConcreteTextController(model, view);
    String expectedModel = "Model: load image" + System.lineSeparator() + "Model: dither"
        + System.lineSeparator() + "Model: sepia" + System.lineSeparator() + "Model: save image"
        + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
    String expectedView = "View: setting the scanner in the view" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator()
        + "View: read command from the scanner" + System.lineSeparator()
        + "View: is there another command to read from scanner" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }
}

// if we get rid of the original view code and replace it with new code, there could be bugs
// introduced that's specific to the mock view.
// so if we use the original view code and testing the original view so that we are reducing the
// chances of getting new bugs.
// (Scanner is replacing the readable, the abstraction is the scanner and the readable is passed
// into the scanner. using the
// scanner to parse the string, so all the view code are the same to pick up the bugs in
// both the controller and view.)