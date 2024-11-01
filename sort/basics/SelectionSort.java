package sort.basics;

import java.util.Arrays;

public class SelectionSort {

    private int getSmallestNumbers(int[] numbers, int start, int end) {
        int smallest = numbers[start];
        int index = start;

        for (int i = start; i <= end; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
                index = i;
            }
        }
        return index;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[b];
        numbers[b] = numbers[a];
        numbers[a] = temp;
    }

    public int[] sort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            int index = getSmallestNumbers(numbers, i, length - 1);
            swap(numbers, i, index);
        }

        return numbers;
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] numbers = new int[]{3, 4, 6, 1, 2};
        int[] sortedNumbers = ss.sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
