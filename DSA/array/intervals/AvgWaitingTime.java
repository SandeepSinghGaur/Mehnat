package DSA.array.intervals;

public class AvgWaitingTime {
    public static void main(String[] args) {
        int[][] customers = new int[][]{{5,2},{5,4},{10,3},{20,1}};
        double ans = averageWaitingTime(customers);
        System.out.printf("Average waiting time: %.5f\n", ans);

    }

    private static double averageWaitingTime(int[][] customers) {
        int time = customers[0][1];
        int isOverLap = time+customers[0][0];
        for(int i=1;i<customers.length;i++){
            isOverLap+=customers[i][1];
            if(isOverLap>=customers[i][0]){
                time+=(isOverLap-customers[i][0]);
            }else{
                time+=customers[i][1];
                isOverLap = customers[i][0]+customers[i][1];
            }
        }
        return (double) time / customers.length;
    }
}
