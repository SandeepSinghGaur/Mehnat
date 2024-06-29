package DSA.june2024;

import java.util.*;

public class June05 {
    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};
        List<String> ans = commonChars(words);
        for (String str : ans) {
            System.out.print(str + " ");
        }
    }

    private static List<String> commonChars(String[] words) {
        // Initialize minFreq with the frequency of characters in the first word
        int[] minFreq = new int[26];
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // For each subsequent word, update the frequency counts
        for (int i = 1; i < words.length; i++) {
            int[] charCount = new int[26];
            for (char c : words[i].toCharArray()) {
                charCount[c - 'a']++;
            }
            // Update minFreq to keep the minimum frequency of each character
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charCount[j]);
            }
        }

        // Construct the result list based on the final counts
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
}
