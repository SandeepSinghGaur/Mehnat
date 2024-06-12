package interview.executor_framework;

public class RunnableService implements Runnable{
    int i;
    public RunnableService(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(STR."i \{this.i}");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
