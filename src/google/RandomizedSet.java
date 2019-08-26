package google;
import java.util.*;


/* https://leetcode.com/problems/insert-delete-getrandom-o1/
- Implement data structure that allow insert delete and random in constant time
*/
class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> indices;
    int len;

    public RandomizedSet() {
        arr = new ArrayList<> ();
        indices = new HashMap<> ();
        len = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indices.containsKey(val)) {
            return false;
        }

        arr.add(val);
        indices.put(val, len);
        len ++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indices.containsKey(val)) {
            return false;
        }

        int idx = indices.get(val);
        int last = arr.get(len-1);
        arr.set(idx, last);
        arr.remove(len - 1);
        indices.remove(val);
        indices.replace(last, idx);
        len --;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(len == 1) {
            return arr.get(0);
        }
        Random rand = new Random();
        System.out.println("current array..." + arr + " " + len);
        int idx = rand.nextInt(len);
        return arr.get(idx);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(0);
        rs.remove(0);
        rs.insert(-1);
        rs.remove(0);
        System.out.println("random..."+ rs.getRandom());
    }
}
