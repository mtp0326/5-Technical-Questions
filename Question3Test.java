import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question3Test {

    @Test
    public void singleton() {
        int[][] city = { {0} };
        assertEquals(1, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void singletonNoPath() {
        int[][] city = { {1} };
        assertEquals(-1, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void mediumCityPath() {
        int[][] city = {
                {3, 1, 2, 1},
                {2, 0, 4, 2},
                {3, 2, 3, 3},
                {1, 1, 1, 2},
        };
        assertEquals(4, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void mediumCityNoPath() {
        int[][] city = {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        assertEquals(-1, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void largeCityPath() {
        int[][] city = {
                {0, 1, 0, 1, 1, 5},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 3, 1, 1, 3},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 2, 1, 1, 3}
        };

        assertEquals(5, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void largeCityNoPath() {
        int[][] city = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 3, 1, 1, 3},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 2, 1, 1, 3}
        };

        assertEquals(-1, Question3.getMinimumNumberOfHops(city));
    }

    @Test
    public void publicCase() {
        int[][] city = {
                {1, 6, 2},
                {1, 6, 4},
                {1, 9, 2}
        };

        assertEquals(2, Question3.getMinimumNumberOfHops(city));
    }
}