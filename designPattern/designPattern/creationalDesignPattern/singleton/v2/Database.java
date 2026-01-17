package designPattern.designPattern.creationalDesignPattern.singleton.v2;

public class Database {
    private static Database instance = new Database(); // Eager Loading
    private Database(){}
    public static Database getInstance(){
        return instance;
    }
}
