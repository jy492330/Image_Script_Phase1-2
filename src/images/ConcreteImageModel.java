package images;

/**
 * This class represents an image model used for image manipulation algorithms.
 * It offers all the operations mandated by the ImageModel interface.
 */
public class ConcreteImageModel implements ImageModel {
  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 255;
  private static final double[][] BLUR_KERNEL = {
      {1.0 / 16, 1.0 / 8, 1.0 / 16},
      {1.0 / 8, 1.0 / 4, 1.0 / 8},
      {1.0 / 16, 1.0 / 8, 1.0 / 16}
  };
  private static final double[][] SHARPEN_KERNEL = {
      {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8}
  };
  private static final double[][] GRAYSCALE_FILTER = {
      {0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722}
  };
  private static final double[][] SEPIA_FILTER = {
      {0.393, 0.769, 0.189},
      {0.349, 0.686, 0.168},
      {0.272, 0.534, 0.131}
  };
  private int[][][] imageData;


  @Override
  public void loadImage(String filename) throws IllegalArgumentException {
    imageData = ImageUtilities.readImage("res/" + filename);
  }

  @Override
  public void saveImage(String filename) throws IllegalArgumentException {
    ImageUtilities.writeImage(imageData, filename);
  }

  @Override
  public void applyBlur() {
    applyFilter(imageData, BLUR_KERNEL);
  }

  @Override
  public void applySharpen() {
    applyFilter(imageData, SHARPEN_KERNEL);
  }

  // Helper method for Blur and Sharpen
  // apply filter to the whole image
  private void applyFilter(int[][][] image, double[][] kernel) {
    int[][][] originalData = image;
    imageData = new int[imageData.length][imageData[0].length][imageData[0][0].length];
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          // initializing one cell of the 3d array / one individual element of the 3d array
          // processing all the colors for all pixels of the image
          imageData[r][c][d] = applyFilter(originalData, r, c, d, kernel);
        }
      }
    }
  }

  // Helper method for Blur and Sharpen
  // apply filter to a particular pixel
  private int applyFilter(int[][][] image, int imageR, int imageC, int imageD, double[][] kernel) {
    // identify center of the kernel at position [1][1]
    int centerRow = kernel.length / 2;
    int centerCol = kernel[0].length / 2;
    double newPixColor = 0;  // accumulator (resultant value of the new pixel with kernel overlay)
    //Loop over every pixel in the kernel
    for (int r = 0; r < kernel.length; r++) {
      for (int c = 0; c < kernel[r].length; c++) {
        // (calculate the corresponding index value of the pixel location of the image overlaid
        // by the kernel).
        // neighborRow is the corresponding row value of the pixel in relation to the kernel
        int neighborRow = imageR + (r - centerRow); // imageR is the row index position of the
        // color value of the pixel + (0 - 1), = negative value out of bounds.
        // neighborCol is the corresponding column value of the pixel in relation to the kernel
        int neighborCol = imageC + (c - centerCol); // imageC is the column index position of the
        // color value of the pixel + (0 - 1), this gives a negative value out of bounds
        // to check if the neighborRow and neighborCol are in bounds of the image (below)
        if (neighborRow < image.length && neighborRow > -1 && neighborCol < image[0].length
            && neighborCol > -1) {
          // Calculate the new color value of a pixel based on the kernel filter
          newPixColor += kernel[r][c] * image[neighborRow][neighborCol][imageD];
        }
      }
    }
    return clamp((int) Math.round(newPixColor));
  }

  // Helper method for Blur and Sharpen
  private int clamp(int value) {
    if (value < MINIMUM) {
      value = MINIMUM;
    }
    if (value > MAXIMUM) {
      value = MAXIMUM;
    }
    return value;
  }

  @Override
  public void applyGrayscale() {
    applyLinearFilter(GRAYSCALE_FILTER);
  }

  // Helper method for Grayscale and Sepia
  private void applyLinearFilter(double[][] filter) {
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        int red = clamp((int) Math.round(filter[0][0] * imageData[r][c][0]
            + filter[0][1] * imageData[r][c][1] + filter[0][2] * imageData[r][c][2]));
        int green = clamp((int) Math.round(filter[1][0] * imageData[r][c][0]
            + filter[1][1] * imageData[r][c][1] + filter[1][2] * imageData[r][c][2]));
        int blue = clamp((int) Math.round(filter[2][0] * imageData[r][c][0]
            + filter[2][1] * imageData[r][c][1] + filter[2][2] * imageData[r][c][2]));
        imageData [r][c][0] = red;
        imageData [r][c][1] = green;
        imageData [r][c][2] = blue;
      }
    }
  }

  @Override
  public void applySepia() {
    applyLinearFilter(SEPIA_FILTER);
  }

  @Override
  public void applyDither() {
    applyLinearFilter(GRAYSCALE_FILTER);
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          int oldColor = imageData[r][c][0];
          int newColor;
          if (255 - oldColor < oldColor - 0) {
            newColor = 255;
          } else {
            newColor = 0;
          }
          int error = oldColor - newColor;
          imageData[r][c][d] = newColor;
          applyError(7 / 16.0 * error, r, c + 1, d);
          applyError(3 / 16.0 * error, r + 1, c - 1, d);
          applyError(5 / 16.0 * error, r + 1, c, d);
          applyError(1 / 16.0 * error, r + 1, c + 1, d);
        }
      }
    }
  }

  // Helper method for Dither
  private void applyError(double weight, int r, int c, int d) {
    if (r < imageData.length && r > -1 && c < imageData[0].length
        && c > -1) {
      imageData[r][c][d] = clamp(imageData[r][c][d] + (int) Math.round(weight));
    }
  }

  @Override
  public void applyMosaic(int seeds) throws IllegalArgumentException {
  }

}