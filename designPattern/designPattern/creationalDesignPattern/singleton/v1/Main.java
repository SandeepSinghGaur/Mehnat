package designPattern.designPattern.creationalDesignPattern.singleton.v1;

public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.printf("Singleton Object 1 %s%n", db1);
        System.out.printf("Singleton Object 2 %s", db2);

        RandomClass rc = new RandomClass();
    }
}
