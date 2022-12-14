import java.util.List;

/**
 * <h1>QUESTION 5: ODD SIZED FAMILY TREES</h1>
 * <p/>
 * <p>
 * Class to implement the algorithm to determine the number of odd sized sub-trees in a given
 * family tree.
 * <p/>
 * <p>
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question5 {
    private static boolean[] isOddNumberArr;

    private static int recAddNumberSubtrees(List<List<Integer>> family, int currRoot) {
        int count = 0;
        if (family.get(currRoot).isEmpty()) {
            isOddNumberArr[currRoot] = true;
            return 1;
        }
        for (int child : family.get(currRoot)) {
            count += recAddNumberSubtrees(family, child);
        }
        count++;
        if (count % 2 != 0) {
            isOddNumberArr[currRoot] = true;
        }
        return count;
    }

    /**
     * Returns the number of odd sized sub-trees in a given family tree.
     *
     * @param family an adjacency list of the family tree
     * @param root   the favorite number of the root of the family tree
     * @return the number of odd sized sub-trees
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int getNumberOfOddSubtrees(List<List<Integer>> family, int root) {
        isOddNumberArr = new boolean[family.size()];
        recAddNumberSubtrees(family, root);

        int countOdd = 0;
        for (int i = 0; i < isOddNumberArr.length; i++) {
            if (isOddNumberArr[i]) {
                countOdd++;
            }
        }
        return countOdd;
    }
}