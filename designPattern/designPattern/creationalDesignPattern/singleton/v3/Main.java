package designPattern.designPattern.creationalDesignPattern.singleton.v3;

public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.printf("Singleton Object 1"+" "+ db1+"\n");
        System.out.printf("Singleton Object 2"+" "+ db2);
    }
}
