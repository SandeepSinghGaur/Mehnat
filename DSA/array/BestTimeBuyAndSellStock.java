package DSA.array;

public class BestTimeBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println("Max Profit:: "+ans);
    }

    private static int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell = 0;
        for(int i=0;i<prices.length;i++){
            buy = Math.min(buy,prices[i]);
            sell = Math.max(sell,prices[i]-buy);
        }
        return sell;
    }
}
