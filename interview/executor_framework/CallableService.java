package interview.executor_framework;

import java.util.concurrent.Callable;

public class CallableService implements Callable {
    int [] arr;
    int sum = 0;

    public CallableService( int[] arr){
        this.arr = arr;
    }
    @Override
    public Object call() throws Exception {
        try{

            Thread.sleep(100);
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    public int getSum() {
        return sum;
    }
}
