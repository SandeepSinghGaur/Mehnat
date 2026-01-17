package designPattern.designPattern.creationalDesignPattern.factory.SimpleFactoryDBBYNaman.v1;

public class DatabaseFactory {
    public static Database getDatabse(DatabaseType type){
        switch (type){
            case MYSQL:
                return new MYSqlDatabase();
            case POSTGRE:
                return new PostGreDatabase();
        }
        throw new RuntimeException("Invalid DatabaseType" + " " + type);
    }
}
