package array;
import java.util.*;


// https://leetcode.com/problems/group-anagrams/
// Give list of word, group them into same anagrams
// Solution: sort each word and use hashmap
// - Optimize: use array of 26 to count each char, use that string array as key
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<List<String>>();

    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for(String str: strs){
        char[] arr = new char[26];

        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        String ns = new String(arr);

        if(map.containsKey(ns)){
            map.get(ns).add(str);
        }else{
            ArrayList<String> al = new ArrayList<String>();
            al.add(str);
            map.put(ns, al);
        }
    }

    result.addAll(map.values());

    return result;
}
}
