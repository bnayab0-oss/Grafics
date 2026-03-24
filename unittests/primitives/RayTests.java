package primitives;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RayTests {

    /**
     * Test method for {@link primitives.Ray#getPoint(double)}.
     */
    @Test
    void testGetPoint() {
        Ray ray = new Ray(new Point(1, 0, 0), new Vector(1, 0, 0));

        // ============ Equivalence Partitions Tests =============
        // EP01: Positive distance
        assertEquals(new Point(2, 0, 0), ray.getPoint(1), "getPoint() positive distance wrong");

        // EP02: Negative distance (if supported by your logic)
        assertEquals(new Point(0, 0, 0), ray.getPoint(-1), "getPoint() negative distance wrong");

        // =============== Boundary Values Tests ==================
        // BV01: Zero distance
        assertEquals(new Point(1, 0, 0), ray.getPoint(0), "getPoint() zero distance wrong");
    }
}