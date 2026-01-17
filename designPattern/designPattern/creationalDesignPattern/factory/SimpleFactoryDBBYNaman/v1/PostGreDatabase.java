package designPattern.designPattern.creationalDesignPattern.factory.SimpleFactoryDBBYNaman.v1;

public class PostGreDatabase implements Database {

    public Query createQuery(){
        return new PostGreQuery();
    }
}
