package graph;
import java.util.*;


// https://leetcode.com/problems/reconstruct-itinerary/
// Give a list of flight from, to, begin at JFK
// Reconstruct the itinerary, if there're multiple return alpha order
// use priority queue to store list of to airport sort by alpha order
// Run DFS at first airport JFK, use LinkedList to store so that dont need to
// reverse the list
public class ReconstructItinerary {
    private HashMap<String, PriorityQueue<String>> flights = new HashMap<>();

    private void dfs(String airport, LinkedList<String> ans) {
        PriorityQueue<String> queue = flights.get(airport);
        while(queue != null && !queue.isEmpty()) {
            String nextAirport = queue.poll();
            dfs(nextAirport, ans);
        }

        ans.addFirst(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        if(tickets.size() == 0) {
            return ans;
        }

        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!flights.containsKey(from)) {
                flights.put(from, new PriorityQueue<String>());
            }
            flights.get(from).offer(to);
        }

        if(!flights.containsKey("JFK")) {
            return ans;
        }

        dfs("JFK", ans);
        return ans;
    }
}
