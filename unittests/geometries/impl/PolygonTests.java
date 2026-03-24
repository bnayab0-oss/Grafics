package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class PolygonTests {

    /**
     * Test method for {@link geometries.impl.Polygon#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests =============
        // EP01: Simple test for a square in the X-Y plane
        Polygon poly = new Polygon(
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(1, 1, 0),
                new Point(0, 1, 0)
        );

        // הנורמל של מישור XY הוא ציר Z (0,0,1)
        Vector n = poly.getNormal(new Point(0.5, 0.5, 0));

        // וודא שהנורמל הוא יחידה (אורך 1)
        assertEquals(1, n.length(), 0.00001, "Polygon normal is not a unit vector");

        // וודא שהכיוון נכון (מאונך למישור)
        // הערה: תלוי בסדר הקודקודים, זה יכול להיות (0,0,1) או (0,0,-1)
        assertTrue(Math.abs(n.dotProduct(new Vector(1, 0, 0))) < 0.00001, "Normal is not orthogonal to X axis");
        assertTrue(Math.abs(n.dotProduct(new Vector(0, 1, 0))) < 0.00001, "Normal is not orthogonal to Y axis");
    }
}