import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Question1Test {
    @Test
    public void singleFlightNoConditions() {
        List<Integer> expected = new LinkedList<>();
        expected.add(0);

        List<Integer> actual = Question1.getFlightDepartureSchedule(1, new int[0][2]);
        assertEquals(expected, actual);
    }

    @Test
    public void threeFlightsNoConditions() {
        List<Integer> expected = new LinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        List<Integer> actual = Question1.getFlightDepartureSchedule(3, new int[0][2]);
        assertEquals(expected, actual);
    }

    @Test
    public void threeFlightsSimpleConditions() {
        List<Integer> expected = new LinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        int[][] conditions = {
                {2, 1},
                {1, 0}
        };

        List<Integer> actual = Question1.getFlightDepartureSchedule(3, conditions);
        assertEquals(expected, actual);
    }

    @Test
    public void publicCase() {
        List<Integer> expected = new LinkedList<>();
        expected.add(2);
        expected.add(1);
        expected.add(3);
        expected.add(0);

        int[][] conditions = {
                {3, 2},
                {1, 2},
                {0, 3},
                {0, 1}
        };

        List<Integer> actual = Question1.getFlightDepartureSchedule(4, conditions);
        assertEquals(expected, actual);
    }

    @Test
    public void singleFlightSameFlightCondition() {
        int[][] conditions = new int[1][2];
        conditions[0][0] = 0;
        conditions[0][1] = 0;

        List<Integer> actual = Question1.getFlightDepartureSchedule(1, conditions);
        assertEquals(new LinkedList<>(), actual);
    }

    @Test
    public void impossibleConditionSimple() {
        int[][] conditions = {
                {0, 1},
                {1, 0}
        };

        List<Integer> actual = Question1.getFlightDepartureSchedule(2, conditions);
        assertEquals(new LinkedList<>(), actual);
    }

    @Test
    public void impossibleConditionLargerCycle() {
        int[][] conditions = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        List<Integer> actual = Question1.getFlightDepartureSchedule(4, conditions);
        assertEquals(new LinkedList<>(), actual);
    }

    @Test
    public void impossibleConditionsComplex() {
        int[][] conditions = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1},
        };

        List<Integer> actual = Question1.getFlightDepartureSchedule(4, conditions);
        assertEquals(new LinkedList<>(), actual);
    }

    @Test
    public void manySolutions() {

    }
}