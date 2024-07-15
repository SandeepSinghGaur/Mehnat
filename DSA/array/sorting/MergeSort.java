package DSA.array.sorting;

public class MergeSort {
        public static void main(String[] args) {
            int[] arr = new int[]{1, 9, 2, 3, 4, 1};
            mergeSort(arr);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(STR."\{i} ");
            }
        }

        private static void mergeSort(int[] arr) {
            if (arr.length < 2) {
                return; // Array is already sorted if it has less than 2 elements
            }
            mergeSort(arr, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);
                merge(arr, low, mid, high);
            }
        }

        private static void merge(int[] arr, int low, int mid, int high) {
            int n1 = mid - low + 1;
            int n2 = high - mid;

            int[] left = new int[n1];
            int[] right = new int[n2];

            // Copying data to temporary arrays left[] and right[]
            for (int i = 0; i < n1; i++) {
                left[i] = arr[low + i];
            }
            for (int j = 0; j < n2; j++) {
                right[j] = arr[mid + 1 + j];
            }

            // Merging the temporary arrays back into arr[low..high]
            int i = 0, j = 0, k = low;
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            // Copy the remaining elements of left[], if any
            while (i < n1) {
                arr[k] = left[i];
                i++;
                k++;
            }

            // Copy the remaining elements of right[], if any
            while (j < n2) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }



