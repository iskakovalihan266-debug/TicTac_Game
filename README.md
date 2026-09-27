# 🎮 Tic-Tac-Toe Game in Java

A simple **console-based Tic-Tac-Toe game** developed in Java using Object-Oriented Programming (OOP) principles.

The game supports two players, allows players to choose their symbols, checks for wins and draws, and stores the history of completed games.

## 📌 Features

* 👥 Two-player game
* ❌⭕ Player symbol selection (`X` or `O`)
* 🎯 Row and column input for moves
* ✅ Win detection
* 🤝 Draw detection
* 📜 Game history
* 🚫 Invalid move protection
* 🚪 Exit option
* 🧱 Object-Oriented Programming structure

## 🛠️ Technologies

* **Java**
* **ArrayList**
* **2D Arrays**
* **Scanner**
* **Object-Oriented Programming (OOP)**

## 📂 Project Structure

The project consists of several classes:

### `Players`

Stores information about each player:

* Player name
* Player symbol (`X` or `O`)

### `Board`

Responsible for the game board.

Main functions:

* Creating a 3×3 board
* Printing the board
* Checking whether a move is valid
* Checking whether the board is full
* Checking for a winning combination
* Returning a copy of the board

### `TicTac`

Controls the main game process.

It is responsible for:

* Switching between players
* Getting player moves
* Checking win/draw conditions
* Saving the finished game to history

### `History`

Stores completed game boards using:

```java
ArrayList<char[][]>
```

It allows the user to view previous games.

### `Task`

Contains the `main()` method and the main menu.

The menu has three options:

```text
1. Start Game
2. Show History
3. Exit
```

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repository-name.git
```

### 2. Open the project

Open the project in:

* IntelliJ IDEA
* Eclipse
* VS Code
* or another Java IDE

### 3. Run the program

Run:

```text
Task.java
```

## 🎮 How to Play

After starting the program, you will see:

```text
--- TIC-TAC GAME ---
Choose one of Options:
1. Start Game
2. Show History
3. Exit
Your choice:
```

Choose:

```text
1
```

Then enter the names of both players.

Example:

```text
Enter the name of Player1: Alikhan
Enter the name of Player2: Alex
```

Player 1 chooses a symbol:

```text
Alikhan Choose symbol: 'X'->1  'O'->2
```

Then the game starts.

For every move, enter a row and column from `1` to `3`.

Example:

```text
Choose Row (1-3): 1
Choose Col (1-3): 2
```

The board will look like:

```text
| X | O |   |
-------------
|   | X |   |
-------------
|   |   | O |
-------------
```

## 🏆 Winning Conditions

A player wins when they get three identical symbols in:

### Row

```text
X | X | X
---------
  | O |  
---------
  |   |
```

### Column

```text
X | O |  
---------
X |   |  
---------
X |   |
```

### Diagonal

```text
X | O |  
---------
  | X |  
---------
  |   | X
```

If all cells are occupied and nobody wins, the result is:

```text
Draw game
```

## 📜 Game History

After a game finishes, the final board is saved to the history.

Select:

```text
2. Show History
```

Example:

```text
--- HISTORY OF GAMES ---
Game #1
 X | O | X
-----------
 O | X | O
-----------
 X |   | O
```

Multiple completed games can be stored in the same program session.

## 🧠 OOP Concepts Used

This project demonstrates several important Java OOP concepts.

### Encapsulation

Player information is stored in private fields:

```java
private String PlayerName;
private char symbol;
```

Access is provided through getter methods:

```java
getName()
getSymbol()
```

### Classes and Objects

The project contains several classes:

```text
Players
Board
TicTac
History
Task
```

Objects are created from these classes to organize the program.

### Composition

`TicTac` contains objects of other classes:

```java
private Board board1;
private Players Player1;
private Players Player2;
private History history;
```

This allows different classes to have separate responsibilities.

## 📊 Main Data Structures

### 2D Array

The Tic-Tac-Toe board is represented using:

```java
char[][] board = new char[3][3];
```

### ArrayList

Game history is stored using:

```java
ArrayList<char[][]> historyOfGames
```

This allows the program to store multiple completed game boards.

## 📸 Example

```text
--- TIC-TAC GAME ---
Choose one of Options:
1. Start Game
2. Show History
3. Exit
Your choice: 1

Enter the name of Player1: Alikhan
Enter the name of Player2: Alex

Alikhan Choose symbol: 'X'->1  'O'->2
1

|   |   |   |
-------------
|   |   |   |
-------------
|   |   |   |
-------------

Alikhan moves
Choose Row (1-3): 1
Choose Col (1-3): 1
```

After several moves:

```text
| X | O |   |
-------------
|   | X |   |
-------------
| O |   | X |
-------------

The player Alikhan wins!!!
```

## 🎯 Project Goal

The main goal of this project is to practice:

* Java programming
* OOP principles
* Classes and objects
* Encapsulation
* 2D arrays
* ArrayList
* Loops and conditions
* User input
* Game logic
* Basic project organization

## 👨‍💻 Author

**Iskakov Alikhan**

Java / IT Student

---

