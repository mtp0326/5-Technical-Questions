import java.util.LinkedList;
import java.util.List;

/**
 * <h1>QUESTION 3: BUNNY HOP</h1>
 * <p/>
 * <p>
 * Class to implement the algorithm to find the minimum number of hops a bunny rabbit
 * must make to navigate from the bottom right corner to the top left corner of the city.
 * <p/>
 * <p>
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question3 {

    /**
     * Returns the minimum number of hops needed for the bunny rabbit to make its way from the
     * bottom right corner to the top left corner given the hopping constraints in the writeup,
     * or -1 if a path does not exist.
     *
     * @param city an n x n 2d-array representing the city where each entry is a positive integer
     *             which defines how many cells the bunny can hop up or to the left when that
     *             entry is reached.
     * @return the minimum number of hops the bunny needs to make, or -1 if there is no
     * possible path
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int getMinimumNumberOfHops(int[][] city) {
        boolean[][] discovered = new boolean[city.length][city.length];
        List<Pair<Integer, Integer>> newQueueList = new LinkedList<>();
        discovered[city.length - 1][city.length - 1] = true;
        List<Pair<Integer, Integer>> queueList;
        newQueueList.add(new Pair<>(city.length - 1, city.length - 1));
        int index = 0;
        while (!newQueueList.isEmpty()) {
            index++;
            queueList = newQueueList;
            newQueueList = new LinkedList<>();
            for (Pair<Integer, Integer> queue : queueList) { //key = x, value = y (key, value)
                int hops = city[queue.getValue()][queue.getKey()];
                //down
                if (queue.getValue() + hops <= city.length - 1
                        && !discovered[queue.getValue() + hops][queue.getKey()]) {
                    discovered[queue.getValue() + hops][queue.getKey()] = true;
                    newQueueList.add(new Pair<>(queue.getKey(), queue.getValue() + hops));
                }
                //up
                if (queue.getValue() - hops >= 0) {
                    if (queue.getKey() == 0 && queue.getValue() - hops == 0) {
                        return index;
                    }
                    if (!discovered[queue.getValue() - hops][queue.getKey()]) {
                        discovered[queue.getValue() - hops][queue.getKey()] = true;
                        newQueueList.add(new Pair<>(queue.getKey(), queue.getValue() - hops));
                    }
                }
                //left
                if (queue.getKey() - hops >= 0) {
                    if (queue.getKey() - hops == 0 && queue.getValue() == 0) {
                        return index;
                    }
                    if (!discovered[queue.getValue()][queue.getKey() - hops]) {
                        discovered[queue.getValue()][queue.getKey() - hops] = true;
                        newQueueList.add(new Pair<>(queue.getKey() - hops, queue.getValue()));
                    }
                }
                //right
                if (queue.getKey() + hops <= city.length - 1
                        && !discovered[queue.getValue()][queue.getKey() + hops]) {
                    discovered[queue.getValue()][queue.getKey() + hops] = true;
                    newQueueList.add(new Pair<>(queue.getKey() + hops, queue.getValue()));
                }
            }
        }

        return -1;
    }
}