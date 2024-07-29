package DSA.array;

public class CountFrequencyInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3};
        int n = 2;
        // int ans = countFrequentUsingCountingSort(arr, n);
        int occurrences = countOccurrences(arr, n);

        System.out.println(STR."Number of occurrences of \{n}: \{occurrences}");
        // System.out.println("Count Frequency In Sorted Array " + ans);
    }

    private static int countOccurrences(int[] arr, int n) {
        int firstIndex = firstOccurrences(arr, n);
        if (firstIndex == -1) {
            return 0; // element n is not present in the array
        }
        int lastIndex = lastOccurrences(arr, n);
        return lastIndex - firstIndex + 1;
    }

    private static int firstOccurrences(int[] arr, int n) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                if (mid == 0 || arr[mid - 1] < n) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int lastOccurrences(int[] arr, int n) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                if (mid == arr.length - 1 || arr[mid + 1] > n) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int countFrequentUsingCountingSort(int[] arr, int n) {
        int maxElement = arr[arr.length - 1];
        int[] count = new int[maxElement + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        return count[n];
    }
}
