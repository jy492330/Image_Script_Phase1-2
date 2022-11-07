

# Image Script (CS5004 Mini-Project 8)
2nd phase of the MVC application in Java

## Table of Contents 

* [Overview](#overview)
* [List of features](#list-of-features)
* [Limitations](#limitations)
* [How to run](#how-to-run)
* [How to use the program](#how-to-use-the-program)
* [Examples](#examples)
* [Citations](#citations)


## Overview
This project is a continuation of the previous assignment to create a full-stack MVC application which implements various types of image manipulations, image scripting and interactive graphical user interface.The previous phase of the project has focused on 4 of the 6 image algorithms for the image model. The required tasks in this phase are to implement the 5th algorithm chosen to be the dither image manipulation effect in this assignment, write a user-defined script with which can be read as single-line commands with or without arguments, implement a controller and a text-based view to support the handling of the script file, implement tests to test the controller in isolation from the model and view, and create a README.md file.

The project contains three main folders: src/folder, test/folder and res/folder. The src/folder contains two packages named **images** and **script**. The **images** package has the class file of the model, the model interface and other class files related to model. The **script** package has the class files of the controller and view, the view interface, and the driver to run the script. The test/folder contains mock files of the model, the view, and test file of the controller. The res/folder contains the two .png example images, the script file, the resulting images generated from the program and information of citations.


## List of features

* A fully implemented **dither** algorithm in the **ConcreteImageModel** with a helper method.
* Provided Readable abstraction in the **ScriptDriver** to process a file and using the scanner to subsequently read the next line from the script file.
* Coded defensively in the **ScriptDriver** to allow only the first file name input to be processed regardless of the number of file name input by the user. 
* Provided error handling in the **ScriptDriver** to catch any IOExceptions when file cannot be opened with a helpful message. 
* Provided defensive coding and error handling in the **ConcreteTextController** to catch Illegal Argument Exceptions and IOException thrown as Illegal Argument Exception for load and save image with a print error helper method. In addition, added helpful line number specific error messages when applying the 5 algorithm commands from the script in the unhappy cases. 
* Created a thorough list of command lines in the script to capture both the happy and unhappy cases for the 6 algorithms and in the load and save steps.
* Included a robust list of image manipulation commands to test each individual algorithm and the different combined affects.
* Created a mock text model and a mock text view to independently and thoroughly test the controller from the original model and view with the use of StringBuilder and Scanner. 


## Limitations

* Unable to test the mosaic algorithm in the **ConcreteTextControllerTest** as it has not been implemented and unable to overwrite the seed argument for this method in the mock model that implements the **ImageModel** interface.

* Unable to test the unhappy scenarios of the 6 algorithms that trigger error print statements in the controller due to the limitation of the mock model which relies on the hard coded strings in the model log. 

## How to run

* You can run a jar file that contains a manifest file using this code `java -jar fileName.jar` or `java -jar -classpath abc.jar fileName.jar`.  
* You can run a jar file that does not contain a manifest file by simply runing the main class given its path `java -cp ./fileName.jar MainClass`. 
* The file names of the two images are **brisbane city** and **city development**.
* The file names of the class files in the **images** package:

  ![Class File Names ](Info/File%20Names_images.JPG)
* The file names of the class files in the **script** package:

  ![Class File Names](Info/File%20Names_Script.JPG)


## How to use the program

* Open the **ScriptDriver** main program located inside the script package. 
* Run the **ScriptDriver** from an IDE.


## Examples
* This script is intended to run the 6 algorithm commands and their arguments e.g. image file name or secondary algorithm effect after the first command word.
* Below is the expected output of the script.

> An error has occurred on line 1: Save requires a file name\
> An error has occurred on line 3: Blur must be a line by itself.\
> An error has occurred on line 4: Blur requires an image to be loaded\
> An error has occurred on line 6: Sharpen must be a line by itself.\
> An error has occurred on line 7: Sharpen requires an image to be loaded\
> An error has occurred on line 9: Grayscale must be a line by itself.\
> An error has occurred on line 10: Grayscale requires an image to be loaded.\
> An error has occurred on line 12: Sepia must be a line by itself.\
> An error has occurred on line 13: Sepia requires an image to be loaded.\
> An error has occurred on line 15: Dither must be a line by itself.\
> An error has occurred on line 16: Dither requires an image to be loaded.\
> An error has occurred on line 18: Mosaic requires a seed argument.\
> An error has occurred on line 19: Mosaic requires an image to be loaded.\
> An error has occurred on line 63: Dither must be a line by itself.\
> An error has occurred on line 65: Mosaic is not implemented until assignment 9 is given.\
> An error has occurred on line 67: Load requires a file name\
> An error has occurred on line 69: Invalid command: write\
> An error has occurred on line 71: Something went wrong reading the image file.\
> An error has occurred on line 73: Error occurred writing the data to the file.
>
> Process finished with exit code 0


## Citations

* Please see information of citation inside the res/folder.
* [Stack Overflow - Run jar file](https://stackoverflow.com/questions/6780678/run-class-in-jar-file)
