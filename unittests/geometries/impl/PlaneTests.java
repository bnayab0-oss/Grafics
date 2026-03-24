package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class PlaneTests {

    /** Test method for {@link geometries.impl.Plane#getNormal(primitives.Point)}. */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests =============

        // EP01: Test with point and normal constructor
        Vector n = new Vector(0, 0, 1);
        Plane pl1 = new Plane(new Point(0, 0, 1), n);
        assertEquals(n, pl1.getNormal(new Point(1, 1, 1)), "getNormal(Point) wrong result");

        // EP02: Test with 3 points constructor
        Point p1 = new Point(0, 0, 1);
        Point p2 = new Point(1, 0, 1);
        Point p3 = new Point(0, 1, 1);
        Plane pl2 = new Plane(p1, p2, p3);

        Vector res = pl2.getNormal(p1);
        // וודא שהנורמל מאונך למישור (מכפלה סקלרית עם וקטור על המישור צריכה להיות 0)
        assertEquals(0, res.dotProduct(p2.subtract(p1)), 0.00001, "Normal is not orthogonal to the plane");
        assertEquals(1, res.length(), 0.00001, "Normal length is not 1");
    }
}