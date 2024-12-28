
package gametreeprogram;

// Razan Alamri,Program 3 Binary Search Tree Program, 5-11-2021.
import java.io.*;
import java.util.*;

public class MainProgram {
    // arraylist for GameTree
    static GameTree GameTreeOfPlayers = new GameTree();

    public static void main(String[] args) throws Exception {

        File inputFile = new File("IntialInformationProgram#3.txt");
        // check if the inputFile is exists.
        if (!inputFile.exists()) {
            System.out.println("The File " + inputFile.getName() + " is not exists");
            System.exit(0);
        }
        File inputFile2 = new File("CommandsProgram#3.txt");
        // check if the inputFile2 is exists.
        if (!inputFile.exists()) {
            System.out.println("The File " + inputFile.getName() + " is not exists");
            System.exit(0);
        }
        // making txt file to print Log in it.
        File outputFile = new File("OutputProgram#3.txt");
        // PrintWriter for that file.
        PrintWriter printSystem = new PrintWriter(outputFile);
        // Scanner to read from IntialInformationProgram#3 txt file.
        Scanner inputSystem = new Scanner(inputFile);
        // Scanner to read from CommandsProgram#3 txt file.
        Scanner inputcommands = new Scanner(inputFile2);

        // print header.
        printSystem.println("		Welcome to Game Tree Program\n" +
                "       ---------------------------------------------------------");

        String check;
        // **** Reading the commands from input ****.
        while (inputcommands.hasNext()) {

            check = inputcommands.next();

            if (check.equalsIgnoreCase("STARTUP")) {// command for start up.

                startUP(inputSystem);

            } else if (check.equalsIgnoreCase("DISPLAY_ALL_PLAYERS")) {// command for display_all_players_info.

                displayAllPlayers(printSystem);

            } else if (check.equalsIgnoreCase("NUM_OF_PLAYERS")) {// command for print number of players.

                numberOfPlayers(printSystem);

            } else if (check.equalsIgnoreCase("DISPLAY_PLAYER_INFO")) {// command for DISPLAY_PLAYER_INFO.

                displayPlayersByID(inputcommands, printSystem);

            } else if (check.equalsIgnoreCase("ADD_PLAYER")) {// command for add new player.

                AddedPlayers(inputcommands);

            } else if (check.equalsIgnoreCase("DELETE_PLAYER")) {// command for delete player.

                RemovePlayers(inputcommands, printSystem);

            } else if (check.equalsIgnoreCase("UPDATE_PLAYER_INFO")) {// command for update player infotmation.

                UpdateForStamina(inputcommands, printSystem);

            } else if (check.equalsIgnoreCase("QUIT")) {// command for stop the KAU Vaccination Centers Management
                                                        // System program.
                printSystem.println("\n			-------------------------------------\n" +
                        "	   	       |	     Good Bye                 |\n" +
                        "                        -------------------------------------                         \n");
                break;
            }
        }

        // * closing the printWriter and input for IntialInformationProgram#3.txt,
        // CommandsProgram#3.txt and OutputProgram#3.txt *.
        inputSystem.close();
        inputcommands.close();
        printSystem.flush();
        printSystem.close();
    }

    // --------------------- this method for generate the BS tree by creating a node
    // for each player in the tree.
    private static void startUP(Scanner inputSystem) {
        // read number of players.
        int numberOfPlayers = inputSystem.nextInt();
        for (int D = 0; D < numberOfPlayers; D++) {
            // read player ID.
            int playerID = inputSystem.nextInt();
            // read player name.
            String playerName = inputSystem.next();

            // create a new player node, and send its ID and its Name.
            PlayerNode addPlayer = new PlayerNode(playerID, playerName);

            // add to GameTree
            GameTreeOfPlayers.add_player(addPlayer);
        }
    }

    // --------------------- this method will output all the players in the game.
    private static void displayAllPlayers(PrintWriter printSystem) {
        // print hedar.
        printSystem.println("The players existed in the game are:\n	\n\n" +
                "       PlayerID         Player Name      Stamina level\n" +
                "---------------------------------------------------");

        // call method display_all_players_info from GameTree class.
        GameTreeOfPlayers.display_all_players_info(printSystem);

        printSystem.println();
        printSystem.println(
                "===================================================================================================\n");
    }

    // --------------------- this method will print the total number of players in
    // the game scene.
    private static void numberOfPlayers(PrintWriter printSystem) {
        // call number of players.
        int nPlayers = GameTreeOfPlayers.num_of_players(GameTreeOfPlayers.getRoot());

        printSystem.println("Number of players : " + nPlayers);
        printSystem.println(
                "===================================================================================================\n");
    }

    // --------------------- this method will print the information about a specific
    // playr.
    private static void displayPlayersByID(Scanner inputcommands, PrintWriter printSystem) {
        // read player ID.
        int playerID = inputcommands.nextInt();
        // search for a specific player By ID and save his node to print.
        PlayerNode specifiedPlayerID = GameTreeOfPlayers.display_player_by_ID(GameTreeOfPlayers.getRoot(), playerID);

        // check if found player.
        if (specifiedPlayerID == null) {
            printSystem.println("Not found any player with ID number <" + playerID + ">");
        } else {
            printSystem.println("Player with ID <" + playerID + "> is <" + specifiedPlayerID.getPlayername()
                    + "> and the stamina level is <" + specifiedPlayerID.getStamina() + ">");
        }
        printSystem.println(
                "===================================================================================================\n");
    }

    // --------------------- this method will create a node in the tree that
    // represents that player in the game.
    private static void AddedPlayers(Scanner inputcommands) {
        // read player ID.
        int playerID = inputcommands.nextInt();
        // read player name.
        String playerName = inputcommands.next();

        // create a new player node, and send its ID and its Name.
        PlayerNode addPlayer = new PlayerNode(playerID, playerName);

        // add to GameTree
        GameTreeOfPlayers.add_player(addPlayer);
    }

    // --------------------- this method will search for this player in the tree
    // then remove their node from the BS tree.
    private static void RemovePlayers(Scanner inputcommands, PrintWriter printSystem) {
        // read player ID will remove.
        int playerID = inputcommands.nextInt();
        // search for a specific player will remove By ID and save his node to print.
        PlayerNode specifiedPlayerID = GameTreeOfPlayers.delete_player(GameTreeOfPlayers.getRoot(), playerID);

        // check if found player.
        if (specifiedPlayerID == null) {
            printSystem.println("Not found any player with ID number <" + playerID + ">");
        } else {
            printSystem.println("The player <" + specifiedPlayerID.getPlayername() + "> left the game");
        }
        printSystem.println(
                "===================================================================================================\n");
    }

    // --------------------- this method will decrease the stamina level for the
    // specified player by 5.
    private static void UpdateForStamina(Scanner inputcommands, PrintWriter printSystem) {
        // read player ID will remove.
        int playerID = inputcommands.nextInt();
        // search for a specific player By ID and save his node.
        PlayerNode specifiedPlayerID = GameTreeOfPlayers.searchByID(GameTreeOfPlayers.getRoot(), playerID);

        // chick if a specific player is exists.
        if (specifiedPlayerID == null) {
            printSystem.println("Not found any player with ID number <" + playerID + " >");

        } else {
            // update stamina level for a specific player.
            PlayerNode specifiedPlayer = GameTreeOfPlayers.update_player(specifiedPlayerID);

            // check if stamina level is zero.
            if (specifiedPlayerID.getStamina() == 0) {
                printSystem.println("The stamina level for the player <" + specifiedPlayer.getPlayername()
                        + "> reaches zero and <" + specifiedPlayer.getPlayername() + "> left the game!” ");
                GameTreeOfPlayers.delete_player(GameTreeOfPlayers.getRoot(), specifiedPlayer.getPlayerID());

            } else {
                // if not zero will be print this massege.
                printSystem.println("The player <" + specifiedPlayer.getPlayername()
                        + "> received a hit and the stamina level reduced by " + GameTreeOfPlayers.getReduced());

            }

        }
        printSystem.println(
                "===================================================================================================\n");
    }
}