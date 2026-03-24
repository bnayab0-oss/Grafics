package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class TriangleTests {

    /**
     * Test method for {@link geometries.impl.Triangle#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        Point p1 = new Point(0, 0, 1);
        Point p2 = new Point(1, 0, 1);
        Point p3 = new Point(0, 1, 1);
        Triangle tri = new Triangle(p1, p2, p3);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple test for a point on the triangle
        Vector res = tri.getNormal(new Point(0.25, 0.25, 1));

        // 1. וודא שהנורמל הוא באורך 1
        assertEquals(1, res.length(), 0.00001, "Triangle normal is not a unit vector");

        // 2. וודא שהנורמל מאונך לאחת הצלעות (מכפלה סקלרית = 0)
        assertEquals(0, res.dotProduct(p2.subtract(p1)), 0.00001, "Normal is not orthogonal to the triangle");
    }
}