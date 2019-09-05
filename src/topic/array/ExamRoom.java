package array;
import java.util.*;


/*
Google
- https://leetcode.com/problems/exam-room/
- Room has N seats from 0...N-1, student enters room on seat maximize distance
if no student, sit on 0
- Solution 1: Keep student seat in sorted list, everytime loop throught list
and find maximum gaps => O(n) to find seat, O(logn) to remove seat
- Solution 2: Use priority queue maximum by distance,
interval (start, end, distance),
get max distance and put a seat make 2 new distance. Leaving merge 2 distance
=> Optimize: Use TreeSet to store interval
*/
class ExamRoom {

    TreeSet<Integer> room;
    int cap;

    public ExamRoom(int N) {
        cap = N;
        room = new TreeSet<> ();
    }


    public int seat() {
        int s = 0;
        if(room.size() > 0) {
            int dist = room.first();
            Integer prev = null;

            for(Integer se: room) {
                if(prev != null) {
                    int d = (se - prev) / 2;
                    if(d > dist) {
                        dist = d;
                        s = prev + d;
                    }
                }
                prev = se;
            }

            if(cap - 1 - room.last() > dist) {
                s = cap - 1;
            }
        }
        room.add(s);
        return s;
    }

    public void leave(int p) {
        room.remove(p);
    }
}
