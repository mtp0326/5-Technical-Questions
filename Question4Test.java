import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question4Test {

    @Test
    public void sameStartEnd() {
        List<String> expected = new LinkedList<>();

        String code1 = "AAA";
        String code2 = "AAA";
        Set<String> codes = new HashSet<>();
        codes.add("AAA");

        List<String> actual = Question4.getSmallestChain(code1, code2, codes);

        assertEquals(expected, actual);
    }

    @Test
    public void oneStep() {
        List<String> expected = new LinkedList<>();
        expected.add("AAA");

        String code1 = "AAA";
        String code2 = "AAB";

        Set<String> codes = new HashSet<>();
        codes.add("AAA");
        codes.add("AAB");
        codes.add("ABA");
        codes.add("BAA");

        List<String> actual = Question4.getSmallestChain(code1, code2, codes);
        expected.add("AAB");
        assertEquals(expected, actual);

        code2 = "ABA";
        actual = Question4.getSmallestChain(code1, code2, codes);
        expected.remove("AAB");
        expected.add("ABA");
        assertEquals(expected, actual);

        code2 = "BAA";
        actual = Question4.getSmallestChain(code1, code2, codes);
        expected.remove("ABA");
        expected.add("BAA");
        assertEquals(expected, actual);
    }

    @Test
    public void noSolutionEmptySet() {
        String code1 = "AAA";
        String code2 = "ABC";

        Set<String> codes = new HashSet<>();

        assertNull(Question4.getSmallestChain(code1, code2, codes));
    }

    @Test
    public void noSolutionNonEmptySetNoSteps() {
        String code1 = "AAA";
        String code2 = "ABC";

        Set<String> codes = new HashSet<>();
        codes.add("AAA");
        codes.add("ABC");
        codes.add("ABB");
        codes.add("ACC");

        assertNull(Question4.getSmallestChain(code1, code2, codes));
    }

    @Test
    public void noSolutionNonEmptySetMultipleSteps() {
        String code1 = "AAA";
        String code2 = "DEF";

        Set<String> codes = new HashSet<>();
        codes.add("AAA");
        codes.add("ABA");
        codes.add("ABC");
        codes.add("DEF");

        assertNull(Question4.getSmallestChain(code1, code2, codes));
    }

    @Test
    public void solutionMultiStep() {
        String code1 = "AAA";
        String code2 = "DEF";

        Set<String> codes = new HashSet<>();
        codes.add("AAA");
        codes.add("ABA");
        codes.add("ABC");
        codes.add("DEA");
        codes.add("DAA");
        codes.add("DEF");

        List<String> expected = new LinkedList<>();
        expected.add("AAA");
        expected.add("DAA");
        expected.add("DEA");
        expected.add("DEF");

        List<String> actual = Question4.getSmallestChain(code1, code2, codes);

        assertEquals(expected, actual);
    }

    @Test
    public void publicCase() {
        String code1 = "MIA";
        String code2 = "BLE";

        Set<String> codes = new HashSet<>();
        codes.add("MIA");
        codes.add("JFK");
        codes.add("MLA");
        codes.add("MLE");
        codes.add("BLE");

        List<String> expected = new LinkedList<>();
        expected.add("MIA");
        expected.add("MLA");
        expected.add("MLE");
        expected.add("BLE");

        List<String> actual = Question4.getSmallestChain(code1, code2, codes);

        assertEquals(expected, actual);
    }
}