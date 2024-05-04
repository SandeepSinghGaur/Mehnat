package daily.may2024;

import java.util.Arrays;

public class May04 {
    public static void main(String[] args) {
        int[] peoples = new int[]{3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(peoples,limit));
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
}
