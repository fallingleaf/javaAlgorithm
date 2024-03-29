package array;
import java.util.*;


// https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
// 'abc' -> 'bcd', group all string that can be shifted as same
// Solution: shift every string to 'a' index by minus to diff of first char
// and use hash map to store
public class GroupShiftedString {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map
                        = new HashMap<String, ArrayList<String>>();

        for(String s: strings){
            char[] arr = s.toCharArray();
            if(arr.length>0){
                int diff = arr[0]-'a';
                for(int i=0; i<arr.length; i++){
                    if(arr[i]-diff<'a'){
                       arr[i] = (char) (arr[i]-diff+26);
                    }else{
                       arr[i] = (char) (arr[i]-diff);
                    }

                }
            }

            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(s);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(s);
                map.put(ns, al);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            Collections.sort(entry.getValue());
        }

        result.addAll(map.values());

        return result;
    }
}
