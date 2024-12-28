# Binary Search Tree Concepts and Algorithms

This repository contains solutions and explanations for working with Binary Search Trees (BST). It includes algorithmic implementations and step-by-step traces for various tasks.

## Contents
1. **Algorithm to Find Leaf Nodes**
   - Recursive method to determine the leaf nodes of a BST.
   - Output Example: 2, 9, 11, 14, 18
   - Code Snippet:

     ```java
     private void printLeafNodes(BSTnode node) {
         // Base case
         if (node != null) {
             // Check if the node is a leaf node
             if (node.getLeft() == null && node.getRight() == null) {
                 // Print the leaf node
                 System.out.printf("%d ", node.getData());
             } else {
                 // Recurse on the left and right subtrees
                 printLeafNodes(node.getLeft());
                 printLeafNodes(node.getRight());
             }
         }
     }
     ```

2. **Tracing the recurSearch() Method**
   - A detailed walkthrough of using a recursive search to find a node in the BST.
   - Example Problem: Search for the node with value 0155.
   - Process:
     - Start from the root node (0145).
     - Compare the target value with the current node’s value:
       - If equal, return the node.
       - If less, move to the left subtree.
       - If greater, move to the right subtree.
     - Repeat until the target node is found or the tree is exhausted.
   - Example Trace:

     ```markdown
     1. Root = 0145
        - 0155 > 0145 → Move to right subtree.
     2. Root = 0179
        - 0155 < 0179 → Move to left subtree.
     3. Root = 0160
        - 0155 < 0160 → Move to left subtree.
     4. Root = 0155
        - 0155 == 0155 → Node found.
     ```

3. **Game Tree Program**

This program implements a Binary Search Tree (BST) to manage players and their respective stamina levels in a game. The program includes functionality for adding, displaying, updating, and removing players based on their IDs.

### Author
Razan Alamri  
Program 3 - Binary Search Tree Program, 5-11-2021

### Contents
1. **MainProgram.java**: The main class implementing the game tree functionality.
2. **PlayerNode.java**: Class representing individual player nodes in the BST.
3. **GameTree.java**: Class handling operations on the game tree.

### Features
- **STARTUP**: Initializes the game tree with player data.
- **DISPLAY_ALL_PLAYERS**: Displays all players currently in the game.
- **NUM_OF_PLAYERS**: Prints the total number of players.
- **DISPLAY_PLAYER_INFO**: Displays information for a specific player by ID.
- **ADD_PLAYER**: Adds a new player to the game tree.
- **DELETE_PLAYER**: Removes a player from the game tree.
- **UPDATE_PLAYER_INFO**: Updates the stamina level of a player.

### Instructions
1. Clone this repository.
2. Ensure you have the necessary input files: `IntialInformationProgram#3.txt` and `CommandsProgram#3.txt`.
3. Run the `MainProgram.java` file.

### Input Files
1. **IntialInformationProgram#3.txt**:
   - Contains initial player data including IDs and names.
2. **CommandsProgram#3.txt**:
   - Contains commands to perform operations on the game tree.

### Output File
- **OutputProgram#3.txt**:
  - Logs the results of all operations performed on the game tree.

### How to Use
1. Execute `MainProgram.java` to interact with the game tree.
2. Use the supported commands to manage players and their stamina levels.

### Notes
- The program utilizes recursion and iterative methods for various operations.
- Ensure that the necessary classes (`PlayerNode`, `GameTree`) are properly implemented before running the program.

