package designPattern.designPattern.creationalDesignPattern.singleton.v3;

public class Database {
    private static Database instance = null;
    private Database(){}

    public static Database getInstance(){
        if(instance == null){
            synchronized(Database.class){
                if(instance == null){
                    instance = new Database();
                }

            }
        }
        return instance;
    }

}
