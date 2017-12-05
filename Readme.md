__Business Game__

This is a multiplayer Board game. Minimum two players required for this game to start. This Board contain four different types of cells, “Treasure”,” Hotel”,” Jail” and “Empty”. When user lands on a cell rules specific to that kind of cells is applied. The rules are listed below. 

1.	*Jail*: When user lands on it, a defined amount, for e.g. Rs 150, will be deducted from user's money.
2.	*Treasure*: When user lands on it, a defined amount, for e.g. Rs 200, will be added to user's money.
3.	*Hotel*: This is a special type of entity. 
	a.	A hotel is of a defined worth, for e.g: Rs. 200. 
	b.	When user lands on it and has required money, he must buy it.
	c.	If any other user lands on a pre-owned hotel, user needs to pay Rs.50 to hotel owner.
4.	*Empty*: No addition or detection of money happens if the user land on this cell

All Players starts at the same point and each player is awarded with 10 chances. User moves in the board on dies rolls output that is between 2-12. At the end of the Game whomever has the maximum balance including cash balance and the worth of the hotel wins. 

The initial values of the game

Initial Money for each player: 1000
Hotel Worth: 200
Hotel Rent: 50
Jail Fine: 150

__Environment__

The Project is implement in maven version control system, import it as a maven project all the dependencies will be downloaded automatically 

__How to run the game__ 

The main class of the Game is Application class in the main package. 
The input to the game i.e layout of the board, rolls of the dies, and the number of players of the game is configured via a properties file 
 
Example of entries in the properties file is given below.
cells=E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E
rolls=4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12
numberOfPlayers=3

The properties file can be passed as an input argument to the application, if not provided the application take the “input.properties” inside the resource folder as the input of the application.

The results of game are printed to the console in the descending order of the maximum balance.

