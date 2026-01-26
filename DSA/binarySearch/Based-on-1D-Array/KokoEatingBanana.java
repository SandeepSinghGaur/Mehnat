package DSA.binarySearch;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int ans = minEatingSpeed(piles,h);
        System.out.println("Minimum eating speed:: "+ans);
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFinishBanana(mid, piles, h)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean canFinishBanana(int k, int[] piles, int h) {
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            int count = piles[i] / k;
            int condition = piles[i] % k;
            if (condition != 0) {
                count++;
            }
            time += (count);
            if (time > h)
                return false;

        }
        return (time <= h);

    }
}
