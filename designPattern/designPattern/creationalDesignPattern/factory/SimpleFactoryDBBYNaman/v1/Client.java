package designPattern.designPattern.creationalDesignPattern.factory.SimpleFactoryDBBYNaman.v1;

public class Client {
    public static void main(String[] args) {
        Database db =DatabaseFactory.getDatabse(DatabaseType.MYSQL);
        Query q = db.createQuery();


    }
}
