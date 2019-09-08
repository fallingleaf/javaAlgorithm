package graph;
import java.util.*;


// https://leetcode.com/problems/course-schedule/
// https://leetcode.com/problems/course-schedule-ii/
// Use topological sort and stack to store finised course
// Topological sort use dfs, whenever found a cycle then course cannot finish
// use status array, if dfs visited node found a cycle
public class CourseSchedule {

    public boolean canFinish(int course, HashMap<Integer, ArrayList<Integer>> edges, Stack<Integer> stack, int[] status) {
        // Visited node
        status[course] = 1;
        for(int edge: edges.get(course)) {
            if(status[edge] == 1) {
                return false;
            }

            if(status[edge] == 0) {
                if(!canFinish(edge, edges, stack, status)) {
                    return false;
                }
            }
        }

        status[course] = -1;
        stack.push(course);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        for(int course = 0; course < numCourses; course++) {
            edges.put(course, new ArrayList<Integer>());
        }

        for(int[] pre: prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }

        int[] status = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int course = 0; course < numCourses; course++) {
            // Processed node
            if(status[course] != -1) {
                if(!canFinish(course, edges, stack, status)) {
                    return new int[0];
                }
            }
        }

        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
