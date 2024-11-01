package sort;

public class MedianOfTwoSortedArrays {

    private double getMedian(int[] mergedArray) {
        if (mergedArray.length % 2 != 0) {
            return mergedArray[mergedArray.length / 2];
        } else {
            return (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / (double) 2;
        }
    }

    private int[] mergedArray(int[] sortedArrayOne, int[] sortedArrayTwo) {
        int[] merged = new int[sortedArrayOne.length + sortedArrayTwo.length];

        int i = 0; // Track the first array
        int j = 0; // Track the second array
        int current = 0; // Track the merged array

        while (i < sortedArrayOne.length && j < sortedArrayTwo.length) {
            if (sortedArrayOne[i] < sortedArrayTwo[j]) {
                merged[current] = sortedArrayOne[i];
                i++;
            } else {
                merged[current] = sortedArrayTwo[j];
                j++;
            }
            current++;
        }

        // Copy the rest of the first array to the merged array
        while (i < sortedArrayOne.length) {
            merged[current++] = sortedArrayOne[i++];
        }

        // Copy the rest of the second array to the merged array
        while (j < sortedArrayTwo.length) {
            merged[current++] = sortedArrayTwo[j++];
        }

        return merged;
    }


    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] sortedArrayOne = new int[]{1, 2};
        int[] sortedArrayTwo = new int[]{3, 4};
        int[] mergedArray = medianOfTwoSortedArrays.mergedArray(sortedArrayOne, sortedArrayTwo);
        double median = medianOfTwoSortedArrays.getMedian(mergedArray);
        System.out.println(median);

    }
}
