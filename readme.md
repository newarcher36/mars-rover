Technologies:

This test is almost written in java 8. I used a bit lombok because I think it is a very
useful library and makes much easier the development.
I used Template design pattern in MissionControl to abastract from the rover interfaces and so on.
I used Command patter to implement the commands of the rover.
Note that you have a simple but nice GUI which prints thr planet,rover and so on.

Difficulties:

- Find the proper design pattern in some cases such as MarsRover and NavigationConsole classes.

What could be improved?

- I would increase the test coverage a bit more.
- I would implement Decorator pattern in MarsRover class and NavigationConsole class
in order to keep at 100% the open/close principle in this part of application.
Anyways I think that I respected this principle quite a lot and of course the other ones as well.
- I would improve some boiler plate code in unit test with Junit 5 but I did not have time. I must hand in the test.
 
You can run my test by an IDE or with this --> ./run

Proper feedback would be really appreciate!!!


note : the welcome banner is better displayed in the IDE.


