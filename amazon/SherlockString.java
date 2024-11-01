package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SherlockString {
    public static String isValid(String s) {
        // Write your code here
        int[] characterCounts = new int[26];

        for (int index = 0; index < s.length(); index++) {
            int currentCharacterIndex = (int) s.charAt(index) - 97;
            int currentCharacterCount = characterCounts[currentCharacterIndex];
            currentCharacterCount++;
            characterCounts[currentCharacterIndex] = currentCharacterCount;
        }

        // Remove zero's from the array
        int nonZeroFrequency = 0;
        for (int i = 0; i < 26; i++) {
            if (characterCounts[i] != 0) {
                nonZeroFrequency++;
            }
        }

        int[] nonZeroCharacterCounts = new int[nonZeroFrequency];
        System.arraycopy(characterCounts, 0, nonZeroCharacterCounts, 0, nonZeroFrequency);

        // All the characters have the same frequency
        if (nonZeroCharacterCounts[0] == nonZeroCharacterCounts[nonZeroFrequency - 1]) {
            return "YES";
        }

        // There is one character with frequency 1 & the rest of the characters have same frequency, remove the character with frequency 1
        if (nonZeroCharacterCounts[0] == 1 && nonZeroCharacterCounts[1] == nonZeroCharacterCounts[nonZeroFrequency - 1]) {
            return "YES";
        }

        // All the frequency but the highest frequency are the same & the highest frequency is 1 greater than the other frequencies
        if (nonZeroCharacterCounts[0] == nonZeroCharacterCounts[nonZeroFrequency - 2] && nonZeroCharacterCounts[nonZeroFrequency - 1] == characterCounts[nonZeroFrequency - 2] + 1) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        String result = SherlockString.isValid(s);
        System.out.println(result);

        bufferedReader.close();
    }
}

