package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SolutionTest {

    @Test
    void testSolution() {

        Integer[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        Integer result = Solution.search(grid);

        assertEquals(4, result);

    }

    @Test
    void testOrangeNotReachable(){

        Integer[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 0, 1}
        };

        Integer result = Solution.search(grid);

        assertEquals(-1, result);

    }

    @Test
    void testAlreadyAllRotten(){

        Integer[][] grid = {
                {0, 2}
        };

        Integer result = Solution.search(grid);

        assertEquals(0, result);

    }

}