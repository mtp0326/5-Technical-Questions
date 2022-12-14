import java.util.LinkedList;
import java.util.List;

/**
 * <h1>QUESTION 1: FLIGHT SCHEDULES</h1>
 * <p/>
 * <p>
 * Class to implement the algorithm to determine a possible flight schedule given the conditions.
 * <p/>
 * <p>
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question1 {

    private static int[] finished;
    private static int[] color; //0 = white, 1 = gray, 2 = black
    private static int time;
    private static boolean isValid = true;

    private static void dfsVisit(LinkedList<Integer>[] adjList, int node) {
        color[node] = 1;

        for (int child : adjList[node]) {
            if (color[child] == 1) {
                isValid = false;
                return;
            }
            if (color[child] == 0 && isValid) {
                dfsVisit(adjList, child);
            }
        }
        color[node] = 2;
        finished[time] = node;
        time++;
    }

    /**
     * Given the number of flights to schedule and conditions for departure, returns one possible
     * departure schedule.
     *
     * @param numFlights the number of flights waiting to take off
     * @param conditions the list of condition pairs (no duplicate pairs may exist)
     * @return one possible valid flight departure ordering, or an empty list if none exists
     * @implSpec you may assume that input is valid (well formatted, mx2 2d-array) and non-null.
     * Do not throw any exceptions.
     */
    public static List<Integer> getFlightDepartureSchedule(int numFlights, int[][] conditions) {
        LinkedList<Integer>[] adjList = new LinkedList[numFlights];

        for (int i = 0; i < numFlights; i++) {
            adjList[i] = new LinkedList<>();
        }
        List<Integer> ans = new LinkedList<>();
        finished = new int[numFlights];
        color = new int[numFlights];

        for (int[] condition : conditions) {
            adjList[condition[1]].add(condition[0]);
        }

        time = 0;
        for (int i = 0; i < numFlights; i++) {
            if (color[i] == 0) {
                dfsVisit(adjList, i);
            }
        }

        if (!isValid) {
            return ans;
        }
        for (int j = finished.length - 1; j >= 0; --j) {
            ans.add(finished[j]);
        }
        return ans;
    }
}
