# VectorGUI
 A vector graphics drawing program developed using Java Swing.
 
 Object Oriented Programming Practical 4 - University of St Andrews
 
 **Compiling & Running Instruction**
 
 1. Navigate to VectorGUI/src directory.

2. Type the following command:
javac model/*.java saveload/*.java  main/*.java delegate/*.java configuration/*.java

3. After it compiled, type this to run the program:
java main/VectorMain
 
 
 
 FEATURES IMPLEMENTED

	BASIC:
	• Drawing straight lines
	• Drawing rectangles
	• Drawing ellipses
	• Drawing diagonal crosses 
	• Undo/redo
	• Different colours

	ADVANCED:
	1. Support for drawing squares and circles. You can draw a square or circle by selecting a rectangle or ellipse and then holding shift while you draw.

	2. Load and save vector drawings:
	A save and load feature is implemented. To save all the vectors you have in your canvas select File (on the top left corner) and then click on save. A window will pop up allowing the user to select where they want to save the canvas. In order for the name given to be accepted it has to end with .vectorboard - !IMPORTANT

	For example: 
	myshapes.vectorboard

	To load a previously drawn canvas go to File->load and select the canvas you want. It must also end with “.vectorboard” to be loaded.

	3. Fill a shape:
	The GUI allows you to fill out a shape (before its drawn). From the bar click on the Bucket icon that signifies fill. Then draw a shape and it will be filled (with the selected colour).


	4. Thickness slider:
	Another functionality added is the thickness slider. The thickness slider is located on the right part of the GUI. It allows the user to select their desired thickness for the shapes that they will draw enabling the creation of shapes in different thicknesses.


	5. Clear canvas:
	An additional very small feature I implemented is to be able to clear the canvas. From the menu bar on the top left select "Clear" and all the shapes in the current canvas will be removed.

HOW TO RUN THE TESTS

1. Navigate to VectorGUI directory.

2. Type the following command to compile the tests:
javac -cp ./src/junit.jar:./src/hamcrest.jar:./src/:. src/tests/*.java  src/model/*.java  src/delegate/*.java  src/saveload/*.java  src/delegate/*.java src/main/*.java

3. After it compiled, type this to run the tests:
java -cp ./src/junit.jar:./src/hamcrest.jar:./src/:. org.junit.runner.JUnitCore tests.ModelTest tests.ShapesTests tests.CrossVectorTest tests.SaveLoadBoardTests tests.TwoDimensionalShapeTests
