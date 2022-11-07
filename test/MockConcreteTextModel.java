import images.ImageModel;

/**
 * Implement of a mock to test the text controller.
 */
public class MockConcreteTextModel implements ImageModel {
  private final StringBuilder log;

  /**
   * Constructor.
   *
   * @param log the model to use
   */
  public MockConcreteTextModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void loadImage(String filename) {
    log.append("Model: load image").append(System.lineSeparator());

  }

  @Override
  public void saveImage(String filename) {
    log.append("Model: save image").append(System.lineSeparator());

  }

  @Override
  public void applyBlur() {
    log.append("Model: blur").append(System.lineSeparator());

  }

  @Override
  public void applySharpen() {
    log.append("Model: sharpen").append(System.lineSeparator());

  }

  @Override
  public void applyGrayscale() {
    log.append("Model: grayscale").append(System.lineSeparator());
  }

  @Override
  public void applySepia() {
    log.append("Model: sepia").append(System.lineSeparator());

  }

  @Override
  public void applyDither() {
    log.append("Model: dither").append(System.lineSeparator());

  }

  @Override
  public void applyMosaic(int seeds) {
    log.append("Model: mosaic(4000)").append(System.lineSeparator());
  }

}
