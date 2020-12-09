# Software-Engineering-PacMan

## Project Option 4: Multiplayer Interactive Pacman Game

#### Project Objective

Software engineering Fundamentals is a hybrid project based course where the group project plays a major role in building student capabilities. It requires you to analyse the requirements of various stakeholders as a team and resolve any conflicts (or vague requirements) with the tutor acting as the product owner, before synthesising your solution iteratively, applying the software engineering principles taught. One major goal of this software engineering assignment is to facilitate teamwork and you will be expected to use techniques such as CRC cards to effectively distribute responsibilities across classes and individual team members. Your team and technical experience in this project will help to meet the course and the program level objectives as well as act as a cornerstone project. The milestone and face-to-face sessions are designed to improve your communication skills. You will also be exposed to tools common in the industry (Git, Trello, LucdChart, JUnit) that foster teamwork and individual accountability.

#### Project Overview

You are required to analyze, design, implement and test a multiplayer version of the Pacman game where a monster (controlled by the server) chases and eats up the player pieces moving in the predefined grid shown below. The players and monster can also move along the arrows shown below to end up along the opposite edge. The aim of the game is for the players to escape from the monster and for the monster to block the players’ escape routes and eat up the players. You game should be designed to be extensible, maintainable and reusable.

#### Initial Waiting Stage

The first player to login should specify the number of players (between 2 and 4). The game should start when the required number of players login an joins in.

#### Initialization Stage

Each player should be allowed to specify one of the four remaining corners as the starting cell (top- left, top-right, bottom-left, bottom-right) in the order they join the game. The monster should initially be placed in the cell at the centre and be made to move towards the nearest player (least number of cells in between).

#### Game Play Stage

When two or more players are at equal distance, the monster may choose to move towards any one of them randomly. A player can block any other player by being stationed along the escape route (with the aim of getting the other player eaten). A monster must wait for a period of time for the food to digest before starting the chase again. The game should stop when only one player is left, who is considered to be the winner. You may use either sockets and threads (using your own protocol) or Java RMI (easier) to implement the game.

#### Post Game Stage

A protocol should be devised allowing a new game to be played if all player want to continue. Otherwise the current scores should be updated on the server.



