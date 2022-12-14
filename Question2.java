import java.util.*;

/**
 * <h1>QUESTION 2: ROOMMATE MATCHING</h1>
 * <p/>
 * <p>
 * Class to implement the algorithm to select roommates from a 2d-array of pairs.
 * <p/>
 * <p>
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question2 {

    /**
     * Returns the set of roommates who mutually requested each other.
     *
     * @param requests the 2d-array of pairs of requests of the form (student, requested roommate).
     *                 Note: a student cannot request themself.
     * @return a set of pairs of roommates who mutually requested each other
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static Set<Pair<String, String>> findMatches(String[][] requests) {
        Set<Pair<String, String>> ans = new HashSet<>();
        Pair<String, String>[] hm = new Pair[requests.length];
        for (int i = 0; i < requests.length; i++) {
            hm[i] = new Pair<>(requests[i][0], requests[i][1]);
        }

        class PairComparator implements Comparator<Pair> {

            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.getValue().hashCode() - p2.getValue().hashCode();
            }
        }

        Arrays.sort(hm, new PairComparator());

        //binary search
        for (int i = 0; i < hm.length; i++) {
            String tgtKey = hm[i].getKey();
            int l = 0, r = hm.length - 1;

            while (l <= r) {
                int m = l + ((r - l) / 2);
                String currValue = hm[m].getValue();
                if (currValue.hashCode() < tgtKey.hashCode()) {
                    l = m + 1;
                } else if (currValue.hashCode() > tgtKey.hashCode()) {
                    r = m - 1;
                } else if (currValue.hashCode() == tgtKey.hashCode()) {
                    if (currValue.equals(tgtKey) && hm[i].getValue().equals(hm[m].getKey())) {
                        if (!ans.contains(hm[i]) && !ans.contains(hm[m])) {
                            ans.add(hm[i]);
                        }
                    }
                    break;
                }
            }
            //if found then match to tgtValue and key if good add to ans.
        }
        return ans;
    }
}