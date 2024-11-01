package sort.basics;

import java.util.Arrays;

public class QuickSort {

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[b];
        numbers[b] = numbers[a];
        numbers[a] = temp;
    }

    /**
     * This method needs to return the index of the pivot.
     * The index of the pivot is always 1 index to the right of the last element in the block of the array
     * where the elements are lesser than the pivot.
     */
    private int partition(int[] numbers, int start, int end, int pivot) {
        while(start <= end) {
            while (numbers[start] < pivot) {
                start++;
            }
            while (numbers[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(numbers, start, end);
                start++;
                end--;
            }

        }
        return start;
    }

    public int[] sort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivot = numbers[(start + end) / 2];
            int pivotIndex = partition(numbers, start, end, pivot);
            sort(numbers, start, pivotIndex - 1);
            sort(numbers, pivotIndex, end);
        }
        return numbers;
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] numbers = new int[]{3, 4, 6, 1, 2};
        int[] sortedNumbers = qs.sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(sortedNumbers));
    }

}
