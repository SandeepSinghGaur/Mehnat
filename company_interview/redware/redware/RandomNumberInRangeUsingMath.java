package company_interview.redware.redware;

public class RandomNumberInRangeUsingMath {
    public static void main(String[] args) {
        int min = 100000; // 100k
        int max = 1000000; // 1000k

        // Generate a random integer between min (inclusive) and max (exclusive)
        int randomInt = (int) (Math.random() * ((max - min) + 1)) + min;
        System.out.println("Random Integer between 100k and 1000k: " + randomInt);

    }
}
