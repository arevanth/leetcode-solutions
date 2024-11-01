package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        boolean value = true;
        Map<String, Integer> wordsInMagazine = new HashMap<String, Integer>();

        // Add all the words in the magazine along with their counts to a HashMap
        for (String word : magazine) {
            int currentCount = wordsInMagazine.getOrDefault(word, 0);
            currentCount++;
            wordsInMagazine.put(word, currentCount);
        }

        //
        for (String word : note) {
            int currentCount = wordsInMagazine.getOrDefault(word, 0);

            if (currentCount == 0) {
                value = false;
                break;
            } else {
                currentCount--;
                if (currentCount == 0) {
                    wordsInMagazine.remove(word);
                } else {
                    wordsInMagazine.put(word, currentCount);
                }
            }
        }

        if (value) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        RansomNote.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

