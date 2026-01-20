package DSA.array;


public class BestTimeBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println("Max Profit ::"+ans);
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
