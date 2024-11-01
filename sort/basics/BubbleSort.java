package sort.basics;

import java.util.Arrays;

public class BubbleSort {

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[b];
        numbers[b] = numbers[a];
        numbers[a] = temp;
    }

    public int[] sort(int[] numbers) {
        int length = numbers.length;

        for (int i = length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j <= i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] numbers = new int[]{3, 4, 6, 1, 2};
        int[] sortedNumbers = bs.sort(numbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
