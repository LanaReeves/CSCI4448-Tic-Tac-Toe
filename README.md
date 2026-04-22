# CSCI4448 Project - Tic Tac Toe

        Names: Lana Reeves and Samuel Hagen
        Java Version: 25

## Project Description:
- This project will be building a two-player Tic-Tac-Toe game, where the user can choose if they want to play against a bot or another person. The game UI will have a m x m Tic-Tac-Toe board, and each player will be able to place their X or O in a cell. The players will each get assigned a marker (X or O), and for all human players, clicking on a cell during their turn will place the player’s marker on the board. The game will detect if there is a win or a tie.



## Design Patterns 
- Factory Pattern:
  - Is used to create instances of cells, boards, and different types of players. 
  - The PlayerFactory is used to create either a Human or Bot Player. The BoardFactory is used to create a new instance of a board. Both are injected into the TicTacToe builder. 
  - Cell factory is created in the board factory since the only time a new cell needs to be created is when a board is being created.
- Builder Pattern:
  - Is used to create a TicTacToe game instance. 
  - It allows step by step creation of the game with different types of players (Bot vs. Human) and setting the board size without the need for many/large constructors.
- Strategy Pattern
- Command Pattern