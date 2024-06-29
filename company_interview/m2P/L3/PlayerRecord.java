package company_interview.m2P.L3;

public class PlayerRecord {
    private String playerName;
    private int scores;
    private int noOfFours;
    private int noOfSixs;

    public PlayerRecord(String playerName, int scores, int noOfFours, int noOfSixs) {
        this.playerName = playerName;
        this.scores = scores;
        this.noOfFours = noOfFours;
        this.noOfSixs = noOfSixs;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public int getNoOfSixs() {
        return noOfSixs;
    }

    public void setNoOfSixs(int noOfSixs) {
        this.noOfSixs = noOfSixs;
    }
}
