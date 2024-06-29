package company_interview.redware.redware;

import java.util.ArrayList;
import java.util.List;

public class MyTread1 implements Runnable{
    long sum=0;
    List<Integer> item = new ArrayList<>();
    int i;
    int j;

    public MyTread1(List<Integer> item,int i , int j){
        this.item = item;
        this.i = i;
        this.j = j;
    }
    @Override
    public void run() {
        for (int k = i;k<j;k++) {
            sum += item.get(k);
        }
    }

    public long getSum() {
        return sum;
    }
}
