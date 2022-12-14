import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Question2Test {

    @Test
    public void simpleOnePair() {
        HashSet<Pair<String, String>> expected = new HashSet<>();
        expected.add(new Pair<>("a", "b"));

        String[][] request = {
                {"a", "b"},
                {"b", "a"}
        };

        Set<Pair<String, String>> actual = Question2.findMatches(request);
        assertEquals(expected, actual);
    }

    @Test
    public void noPairing() {
        HashSet<Pair<String, String>> expected = new HashSet<>();

        String[][] requests = {
                {"a", "b"}
        };

        Set<Pair<String, String>> actual = Question2.findMatches(requests);

        assertEquals(expected, actual);
    }

    @Test
    public void noPairingMorePairs() {
        HashSet<Pair<String, String>> expected = new HashSet<>();

        String[][] requests = {
                {"a", "b"},
                {"b", "c"},
                {"c", "d"}
        };

        Set<Pair<String, String>> actual = Question2.findMatches(requests);

        assertEquals(expected, actual);
    }

    @Test
    public void morePairs() {
        HashSet<Pair<String, String>> expected = new HashSet<>();
        expected.add(new Pair<>("a", "c"));
        expected.add(new Pair<>("b", "d"));

        String[][] requested = {
                {"a", "c"},
                {"b", "d"},
                {"c", "a"},
                {"d", "b"}
        };

        Set<Pair<String, String>> actual = Question2.findMatches(requested);

        assertEquals(expected, actual);
    }

    @Test
    public void unorderedPairs() {
        HashSet<Pair<String, String>> expected = new HashSet<>();
        expected.add(new Pair<>("a", "b"));

        String[][] requested = {
                {"b", "a"},
                {"d", "e"},
                {"a", "b"},
                {"c", "d"},
                {"e", "c"}
        };

        Set<Pair<String, String>> actual = Question2.findMatches(requested);

        assertEquals(expected, actual);
    }

    @Test
    public void publicCase() {
        String[][] requests = {
                {"Steven", "Will"},
                {"Helen", "Caroline"},
                {"Caroline", "Monal"},
                {"Will", "Steven"}
        };

        HashSet<Pair<String, String>> expected = new HashSet<>();
        expected.add(new Pair<>("Steven", "Will"));

        Set<Pair<String, String>> actual = Question2.findMatches(requests);

        assertEquals(expected, actual);
    }

    @Test
    public void bigRequests() {
        String[][] requests = {
                {"one", "seven"},
                {"two", "eight"},
                {"three", "nine"},
                {"four", "ten"},
                {"five", "eleven"},
                {"six", "twelve"},
                {"seven", "one"},
                {"eight", "two"},
                {"nine", "three"},
                {"ten", "four"},
                {"eleven", "five"},
                {"twelve", "six"}
        };

        HashSet<Pair<String, String>> expected = new HashSet<>();
        expected.add(new Pair<>("one", "seven"));
        expected.add(new Pair<>("eleven", "five"));
        expected.add(new Pair<>("four", "ten"));
        expected.add(new Pair<>("six", "twelve"));
        expected.add(new Pair<>("eight", "two"));
        expected.add(new Pair<>("nine", "three"));

        Set<Pair<String, String>> actual = Question2.findMatches(requests);

        assertEquals(expected, actual);
    }
}
