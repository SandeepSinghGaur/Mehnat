package designPattern.practileLLD.tictaktoe.model;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private Long id;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(Symbol symbol, String name, Long id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Player() {
    }

    public Move makeMove() {
        System.out.println("Please tell row count where you want to move (Starting from 0)");
        int row = scanner.nextInt();
        System.out.println("Please tell col count where you want to move (Starting from 0)");
        int col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
