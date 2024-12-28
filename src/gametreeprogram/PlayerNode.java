package gametreeprogram;

// Razan Alamri,Program 3 Binary Search Tree Program, 5-11-2021.
public class PlayerNode {

    // Data filed
    private int playerID;
    private String Playername;
    private int stamina;
    private PlayerNode right;
    private PlayerNode left;

    // Contructors
    public PlayerNode() {
        playerID = stamina = 0;
        Playername = null;
        right = left = null;
    }

    public PlayerNode(int playerID, String Playername) {
        this.playerID = playerID;
        this.Playername = Playername;
        this.stamina = 15;
    }

    public PlayerNode(int playerID, String Playername, int stamina) {
        this.playerID = playerID;
        this.Playername = Playername;
        this.stamina = stamina;
    }

    public PlayerNode(int playerID, String Playername, int stamina, PlayerNode right, PlayerNode left) {
        this.playerID = playerID;
        this.Playername = Playername;
        this.stamina = stamina;
        this.right = right;
        this.left = left;
    }

    // Setters and Getters of Data filed
    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayername() {
        return Playername;
    }

    public void setPlayername(String Playername) {
        this.Playername = Playername;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public PlayerNode getRight() {
        return right;
    }

    public void setRight(PlayerNode right) {
        this.right = right;
    }

    public PlayerNode getLeft() {
        return left;
    }

    public void setLeft(PlayerNode left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "	" + playerID + " 		" + Playername + "	" + stamina + "	";
    }

}
