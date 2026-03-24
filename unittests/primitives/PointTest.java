package primitives;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTests {

    @Test
    void testSubtract() {
        Point p1 = new Point(1, 2, 3);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple subtract
        assertEquals(new Vector(1, 1, 1), new Point(2, 3, 4).subtract(p1),
                "subtract() wrong result");

        // =============== Boundary Values Tests ==================
        // BV01: Subtract point from itself (should throw exception because of Zero Vector)
        assertThrows(IllegalArgumentException.class, () -> p1.subtract(p1),
                "subtract() for same point does not throw exception");
    }

    @Test
    void testDistanceSquared() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 2, 5);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple distance squared
        assertEquals(4, p1.distanceSquared(p2), 0.00001, "distanceSquared() wrong result");

        // =============== Boundary Values Tests ==================
        // BV01: Distance squared to itself
        assertEquals(0, p1.distanceSquared(p1), 0.00001, "distanceSquared() to itself is not zero");
    }

    @Test
    void testDistance() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 2, 8);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple distance
        assertEquals(5, p1.distance(p2), 0.00001, "distance() wrong result");
    }
}