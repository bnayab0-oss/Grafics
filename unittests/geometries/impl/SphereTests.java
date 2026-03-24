package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class SphereTests {

    /**
     * Test method for {@link geometries.impl.Sphere#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests =============
        // EP01: There is a simple single test here -
        // a point on the surface of a unit sphere at the origin
        Sphere sp = new Sphere(new Point(0, 0, 0), 1.0);
        Point p = new Point(1, 0, 0);
        Vector n = sp.getNormal(p);

        // 1. וודא שהנורמל שהוחזר הוא באורך 1
        assertEquals(1, n.length(), 0.00001, "Sphere normal is not a unit vector");

        // 2. וודא שהנורמל הוא בכיוון הנכון (מהמרכז לנקודה)
        assertEquals(new Vector(1, 0, 0), n, "Sphere getNormal() wrong result");
    }
}