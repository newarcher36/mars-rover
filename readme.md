Technologies:

This test is written in java 8. 
I used lombok because I think it is a very useful library and makes easier the development in some cases.
I used Template design pattern in Control abstract class in order to define a way to execute its methods in the required order.
I used Command pattern to implement the commands of the rover in order to wrap the request under an object as command and encapsulate the logic of execute the command creating a loose coupling. 

How to compile it?

Please execute 'mvn clean install' in the project's root in order to build the jar.

How to run it?
 
a) You can import into your favourite IDE as a maven project and run it.
b) After compilation. you can execute the script in the project's root as following --> ./run

How to play?

First you will be asked to enter the size of the mars map. Note that the map has wrapped edges. Planets are spheres after all.
You will be prompted to enter the initial orientation of mars rover in the map.
You can add as many obstacles at any point in the map as you want. 
Note that the mars rover has obstacle detector.

You will be prompted to enter the commands such as in order to move the rover:
- f : go foreward.
- b : go backward.
- r : rotate to right.
- l : rotate to left.

Enjoy! 


note : the welcome banner is better displayed in an IDE.


