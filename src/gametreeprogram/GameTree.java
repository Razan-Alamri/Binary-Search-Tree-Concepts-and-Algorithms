package gametreeprogram;

// Razan Alamri, Program 3 Binary Search Tree Program, 5-11-2021.
import java.io.PrintWriter;

public class GameTree {

    // Data filed
    private PlayerNode root;
    private int reduced = 5;

    // Contructors
    public GameTree() {
    }

    public GameTree(PlayerNode root) {
        this.root = root;
    }

    // Setters and Getters of Data filed
    public PlayerNode getRoot() {
        return root;
    }

    public void setRoot(PlayerNode root) {
        this.root = root;
    }

    public int getReduced() {
        return reduced;
    }

    public void setReduced(int reduced) {
        this.reduced = reduced;
    }

    // --------------------Method---------------------
    // method to add a new player by adding a new node to the tree.
    public void add_player(PlayerNode newplayerp) {

        root = add_player(root, newplayerp);
    }

    private PlayerNode add_player(PlayerNode playerp, PlayerNode newplayerp) {
        // if there is no tree, newplayerp will be the root, so just return it
        if (playerp == null) {
            return newplayerp;
        } // else, we have a tree. Insert to the right or the left
        else {
            // Insert to the LEFT of root
            if (newplayerp.getPlayerID() < playerp.getPlayerID()) {
                // Recursively insert into the left subtree
                // The result of insertion is an updated root of the left subtree
                PlayerNode tempPlayerNode = add_player(playerp.getLeft(), newplayerp);
                playerp.setLeft(tempPlayerNode);
            } // Insert to the RIGHT of root
            else {
                // Recursively insert into the right subtree
                // The result of insertion is an updated root of the right subtree
                PlayerNode tempPlayerNode = add_player(playerp.getRight(), newplayerp);
                playerp.setRight(tempPlayerNode);

            }
        }
        // Return root of updated tree
        return playerp;
    }

    // method that search player By ID
    public PlayerNode searchByID(PlayerNode playerp, int ID) {
        if (playerp == null) {
            return playerp;
        } else {
            // if the data we are searching for is found at p (at the current root)
            if (ID == playerp.getPlayerID()) {
                return playerp;
            } else if (ID < playerp.getPlayerID()) {
                return searchByID(playerp.getLeft(), ID);
            } else {
                return searchByID(playerp.getRight(), ID);
            }
        }
    }

    // method that updates the stamina level for a specific player.
    public PlayerNode update_player(PlayerNode playerp) {

        // if found stamina level of playr then reduced by 5.
        int newlevel = playerp.getStamina() - this.reduced;
        // set stamina level.
        playerp.setStamina(newlevel);
        return playerp;

    }

    // method that removes a particular player from the game by removing their node
    // from the tree.
    public PlayerNode delete_player(PlayerNode playerp, int playeIDRemove) {

        // pointer to store the parent of the PlayerNode
        PlayerNode parent = null;

        // start with the root node
        PlayerNode playerDelet = playerp;

        // search ID in the BST and set its parent pointer
        while (playerDelet != null && playerDelet.getPlayerID() != playeIDRemove) {
            // update the parent to the playerDelet node
            parent = playerDelet;

            // if the given ID is less than the playerDelet node, go to the left subtree;
            // otherwise, go to the right subtree
            if (playeIDRemove < playerDelet.getPlayerID()) {
                playerDelet = playerDelet.getLeft();
            } else {
                playerDelet = playerDelet.getRight();
            }
        }

        // return if the ID is not found in the tree
        if (playerDelet == null) {
            return playerDelet;
        }

        // if node will be deleted it is a leaf node
        if (playerDelet.getLeft() == null && playerDelet.getRight() == null) {
            // if the node to be deleted is not a root node, then set its parent left/right
            // child to null
            if (playerDelet != playerp) {
                if (parent.getLeft() == playerDelet) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } // if the tree has only a root node, set it to null
            else {
                playerp = null;
            }
        } // if node will be deleted has two child
        else if (playerDelet.getLeft() != null && playerDelet.getRight() != null) {
            // find its inorder MaximumID playr
            PlayerNode MaximumID = MaximumID(playerDelet.getLeft());

            // save ID, Name and Stamin for playr with MaximumID
            int ID = MaximumID.getPlayerID();
            String Name = MaximumID.getPlayername();
            int Stamina = MaximumID.getStamina();
            // recursively delete the MaximumID
            delete_player(playerp, MaximumID.getPlayerID());

            // copy ID, Name and Stamin to the playerDelet node
            playerDelet.setPlayerID(ID);
            playerDelet.setPlayername(Name);
            playerDelet.setStamina(Stamina);
        } // if node will be deleted has only one child
        else {
            // choose a child node
            PlayerNode childOfplayerDelet = (playerDelet.getLeft() != null) ? playerDelet.getLeft()
                    : playerDelet.getRight();

            // if the node will be deleted is not a root node, set its parent to its child
            if (playerDelet != playerp) {
                if (playerDelet == parent.getLeft()) {
                    parent.setLeft(childOfplayerDelet);
                } else {
                    parent.setRight(childOfplayerDelet);
                }
            } // if the node will be deleted is a root node, then set the root to the child
            else {
                playerp = childOfplayerDelet;
            }
        }
        return playerDelet;
    }

    // healp method to find MaximumID playr ID node
    public static PlayerNode MaximumID(PlayerNode playerp) {

        while (playerp.getRight() != null) {
            playerp = playerp.getRight();
        }
        return playerp;
    }

    // method that prints the number of players that existed in the game.
    public void display_all_players_info(PrintWriter printSystem) {
        display_all_players_info(root, printSystem);
    }

    private void display_all_players_info(PlayerNode playerp, PrintWriter printSystem) {

        if (playerp != null) {
            // printSystem.println(playerp.toString());
            printSystem.print("\t");
            printSystem.printf("%-16s", playerp.getPlayerID());
            printSystem.printf("%-16s", playerp.getPlayername());
            printSystem.printf("%d", playerp.getStamina());
            printSystem.println();
            display_all_players_info(playerp.getLeft(), printSystem);
            display_all_players_info(playerp.getRight(), printSystem);
        }
    }

    // method that prints all the players' names with their specified IDs and
    // stamina levels.
    public PlayerNode display_player_by_ID(PlayerNode playerp, int ID) {

        if (playerp == null || ID == playerp.getPlayerID()) {
            return playerp;
        } else {
            // if the data we are searching for is found at p (at the current root)
            if (ID < playerp.getPlayerID()) {
                return display_player_by_ID(playerp.getLeft(), ID);
            } else {
                return display_player_by_ID(playerp.getRight(), ID);
            }

        }
    }

    // method that prints the number of players that existed in the game.
    public int num_of_players(PlayerNode playerp) {

        if (playerp == null) {
            return 0;
        } else {
            return 1 + num_of_players(playerp.getLeft()) + num_of_players(playerp.getRight());
        }
    }
}
