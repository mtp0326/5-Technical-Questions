import java.util.*;

/**
 * <h1>QUESTION 4: AIRPORT CODE GAME -- OFF BY ONE!</h1>
 * <p/>
 * <p>
 * Class to implement the algorithm to find the smallest chain between two 3 letter
 * airport codes.
 * <p/>
 * <p>
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question4 {
    private static String[] parents;
    private static Map<String, Integer> hm;

    private static List<String> backtrack(String src, String tgt) {
        List<String> ans = new LinkedList<>();
        String node = tgt;
        while (!node.equals(src)) {
            ans.add(0, node);
            node = parents[hm.get(node)];
        }
        ans.add(0, src);
        return ans;
    }

    /**
     * Solves the "Airport Code Change" game. See complete problem description above.
     * <p/>
     * <p>
     * You may assume that all codes contain only UPPERCASE alphabetic (A-Z) characters.
     *
     * @param code1 the 3 letter airport code you want to start from
     * @param code2 the 3 letter airport code you want to end at
     * @param codes the set of 3 letter airport codes you can use to get from code1 -> code2
     * @return the smallest chain of airport codes to get from {@code code1 -> code2}. {@code code1}
     * should be the first element, and {@code code2} should be the last. If no valid
     * solution exists, return {@code null}. If {@code code1.equals(code2)}, return an empty
     * list.
     * @implSpec you may assume that all inputs are valid. Do not throw any exceptions.
     */
    public static List<String> getSmallestChain(String code1, String code2, Set<String> codes) {
        hm = new HashMap<>();
        int index = 0;
        for (String code : codes) {
            hm.put(code, index);
            index++;
        }
        boolean[] discovered = new boolean[codes.size()];
        parents = new String[codes.size()];
        List<String> newQueueList = new LinkedList<>();
        List<String> queueList;

        if (code1.equals(code2)) {
            return newQueueList;
        }
        if (!codes.contains(code1) || !codes.contains(code2)) {
            return null;
        }

        discovered[hm.get(code1)] = true;
        newQueueList.add(code1);
        while (!newQueueList.isEmpty()) {
            queueList = newQueueList;
            newQueueList = new LinkedList<>();
            for (String queue : queueList) {
                if (queue.equals(code2)) {
                    return backtrack(code1, code2);
                }
                for (String code : codes) {
                    if (!discovered[hm.get(code)]) {
                        int count = 0;
                        for (int i = 0; i < 3; i++) {
                            if (code.charAt(i) == queue.charAt(i)) {
                                count++;
                            }
                        }
                        if (count == 2) {
                            parents[hm.get(code)] = queue;
                            discovered[hm.get(code)] = true;
                            newQueueList.add(code);
                        }
                    }
                }
            }
        }
        return null;
    }
}