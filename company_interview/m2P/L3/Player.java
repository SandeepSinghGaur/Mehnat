package company_interview.m2P.L3;

public class Player {
    private String name;
    private int currentPlayer=0; //0 1
    private int noOfPlayer;
    String[] playerOrder = new String[noOfPlayer];
    public Player(){}

    public Player(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public Player(String name, int currentPlayer, int noOfPlayer, String[] playerOrder) {
        this.name = name;
        this.currentPlayer = currentPlayer;
        this.noOfPlayer = noOfPlayer;
        this.playerOrder = playerOrder;
    }

    public Player(String[] playerOrder) {
        this.playerOrder = playerOrder;
    }

    public String[] getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(String[] playerOrder) {
        this.playerOrder = playerOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getNoOfPlayer() {
        return noOfPlayer;
    }

    public void setNoOfPlayer(int noOfPlayer) {
        this.noOfPlayer = noOfPlayer;
    }
}
