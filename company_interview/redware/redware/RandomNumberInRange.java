package company_interview.redware.redware;

import java.util.Random;

public class RandomNumberInRange {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 100000; // 100k
        int max = 1000000; // 1000k

        // Generate a random integer between min (inclusive) and max (exclusive)
        int randomInt = random.nextInt((max - min) + 1) + min;
        System.out.println("Random Integer between 100k and 1000k: " + randomInt);
    }
}
