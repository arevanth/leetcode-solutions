package search.basics;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] numbers, int searchValue) {
        int low = 0;
        int high = numbers.length - 1;
        int error = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (searchValue < numbers[mid]) {
                high = mid - 1;
            } else if (searchValue > numbers[mid]) {
                low = mid + 1;
            } else
                return mid;
        }

        return error;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] numbers = new int[]{1, 2, 3, 4};
        int searchValue = 3;
        int searchIndex = bs.search(numbers, searchValue);
        if (searchIndex == -1) {
            System.out.println(String.format("Could not find value %s in Array ", searchValue) + Arrays.toString(numbers));
        } else {
            System.out.println(String.format("Found value %s at index %s in Array ", searchValue, searchIndex) + Arrays.toString(numbers));
        }
    }
}
