package sort.basics;

import java.util.Arrays;

public class MergeSort {

    private void merge(int[] numbers, int[] left, int[] right) {
        int i = 0; // Tracks the first array
        int j = 0; // Tracks the second array
        int k = 0; // Tracks the merged array

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                numbers[k++] = left[i++];
            } else {
                numbers[k++] = right[j++];
            }
        }

        while (i < left.length) {
            // Copy the rest of the first array
            numbers[k++] = left[i++];
        }

        while (j < right.length) {
            // Copy the rest of the second array
            numbers[k++] = right[j++];
        }
    }

    public void sort(int[] numbers) {
        if (numbers.length < 2) {
            return; // Base case: arrays with fewer than 2 elements are already sorted
        }

        int middle = numbers.length / 2;
        int[] left = new int[middle];
        int[] right = new int[numbers.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = numbers[i];
        }
        for (int j = middle; j < numbers.length; j++) {
            right[j - middle] = numbers[j];
        }

        sort(left);
        sort(right);
        merge(numbers, left, right);
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] numbers = new int[]{3, 4, 6, 1, 2};
        ms.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
