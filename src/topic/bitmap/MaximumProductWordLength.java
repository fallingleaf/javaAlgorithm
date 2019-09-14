package bitmap;
import java.util.*;


// https://leetcode.com/problems/maximum-product-of-word-lengths/
// Return max product of 2 words length if 2 words are not sharing any common
// characters, because max is 26 char, we could use 4 bytes to mark char exist
// (1 << (char - 'a')), if 2 words do not share common letter => and = 0
public class MaximumProductWordLength {
    public int[] maxProduct(String[] words) {
        int[] arr = new int[words.length];

        // Mark every letter in each word
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                arr[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }

        int res = 0;

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                // 2 words do not share common letters
                if((arr[i] & arr[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
