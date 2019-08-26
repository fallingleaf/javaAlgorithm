package google;
import java.util.*;


// https://leetcode.com/problems/meeting-rooms-ii
// Given an array of meeting time intervals consisting of start and end times
// [[s1,e1],[s2,e2],...] (si < ei),
// find the minimum number of conference rooms required
class MeetingRoom {
    public int minMeetingRooms(int[][] meetings) {
        Comparator<int[]> meetingComp = (obj1, obj2) -> obj1[0] - obj2[0];
        Arrays.sort(meetings, meetingComp);

        PriorityQueue<Integer> queue = new PriorityQueue<> ();
        queue.offer(meetings[0][1]);
        int count = 1;

        for(int i = 1; i < meetings.length; i++) {
            if(meetings[i][0] > queue.peek()) {
                queue.poll();
            } else {
                count++;
            }
            queue.offer(meetings[i][1]);
        }

        return count;
    }

    public static void main(String[] args) {
        MeetingRoom mt = new MeetingRoom();
        int count = mt.minMeetingRooms(new int[][] {{0, 30}, {10, 15}, {16, 35}, {31, 39}});
        System.out.println("min meeting room..." + count);
    }

}
