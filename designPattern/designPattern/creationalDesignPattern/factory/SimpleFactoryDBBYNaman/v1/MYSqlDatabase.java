package designPattern.designPattern.creationalDesignPattern.factory.SimpleFactoryDBBYNaman.v1;

public class MYSqlDatabase implements Database {
    public Query createQuery(){
        return new MySqlQuery();
    }
}
