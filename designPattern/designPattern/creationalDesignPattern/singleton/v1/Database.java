package designPattern.designPattern.creationalDesignPattern.singleton.v1;

public class Database {
    private static Database instance = null;
    private Database(){}

    public synchronized static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
