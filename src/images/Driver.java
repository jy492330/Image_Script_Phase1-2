package images;

/**
 * This class represents the driver of the program to test the ConcreteImageModel class.
 * It is used with the implementation to generate the images specified.
 */
public class Driver {

  /**
   * This is the main method to generate image files.
   * @param args   arguments of the main method.
   */
  public static void main(String[] args) {
    
    String filename = "brisbane city";

    
    ImageModel model = new ConcreteImageModel();
    
    model.loadImage(filename + ".png");
    model.applyBlur();
    model.saveImage(filename + "-blurred-1.png");
    model.applyBlur();
    model.saveImage(filename + "-blurred-2.png");

    model.loadImage(filename + ".png");
    model.applySharpen();
    model.saveImage(filename + "-sharpen-1.png");
    model.applySharpen();
    model.saveImage(filename + "-sharpen-2.png");

    model.loadImage(filename + ".png");
    model.applyGrayscale();
    model.saveImage(filename + "-grayscale.png");

    model.loadImage(filename + ".png");
    model.applySepia();
    model.saveImage(filename + "-sepia.png");

    model.loadImage(filename + ".png");
    model.applyDither();
    model.saveImage(filename + "-dither.png");

    //    model.loadImage(filename + ".png");
    //    model.applyMosaic(15000);
    //    model.saveImage("manhattan-small-mosaic-15000.png");
    //
    //    model.loadImage(filename + ".png");
    //    model.applyMosaic(8000);
    //    model.saveImage("manhattan-small-mosaic-8000.png");
    //
    //    model.loadImage(filename + ".png");
    //    model.applyMosaic(4000);
    //    model.saveImage("manhattan-small-mosaic-4000.png");
    //
    //    model.loadImage(filename + ".png");
    //    model.applyMosaic(1000);
    //    model.saveImage("manhattan-small-mosaic-1000.png");

  }
}
