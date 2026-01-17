package company_interview.redware.redware;

import java.util.ArrayList;
import java.util.List;

/*

Create a random element of 1k
range of element 100k to 1000k
use multi-thread  to process the array and find the sum of array
print the sum and time taken to finish the sum
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<1000;i++){
             int val = 1;
             list.add(val);
        }

        MyTread1 t = new MyTread1(list,0,500);
        Thread thread = new Thread(t);
        Mythread2 t2 = new Mythread2(list,500,1000);
        Thread thread2 = new Thread(t2);
        thread.start();
        thread2.start();
        thread2.join();
        System.out.println(t.getSum());
        System.out.println(t2.getSum());
        System.out.println("==================");
        long sum =  (t.getSum() + t2.getSum());
        System.out.println("Sum: " + sum);


    }
}
