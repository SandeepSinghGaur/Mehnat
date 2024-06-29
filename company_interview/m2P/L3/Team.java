package company_interview.m2P.L3;

public class Team {
    private String teamName;
    private Player player;
    private int over;

    public Team(String teamName, Player player, int over) {
        this.teamName = teamName;
        this.player = player;
        this.over = over;
    }
    public Team(){}

    public Team(int over) {
        this.over = over;
    }

    public Team(Player player) {
        this.player = player;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }
}
