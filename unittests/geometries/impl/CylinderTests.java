package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class CylinderTests {

    @Test
    void testGetNormal() {
        Ray axis = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Cylinder cyl = new Cylinder(1.0, axis, 2.0);

        // ============ Equivalence Partitions Tests =============

        // EP01: Point on the side (shell)
        assertEquals(new Vector(1, 0, 0), cyl.getNormal(new Point(1, 0, 1)), "Cylinder side normal is wrong");

        // EP02: Point on the top base
        assertEquals(new Vector(0, 0, 1), cyl.getNormal(new Point(0.5, 0, 2)), "Cylinder top base normal is wrong");

        // EP03: Point on the bottom base
        assertEquals(new Vector(0, 0, -1), cyl.getNormal(new Point(0.5, 0, 0)), "Cylinder bottom base normal is wrong");

        // =============== Boundary Values Tests ==================

        // BV01: Point at the center of the top base
        assertEquals(new Vector(0, 0, 1), cyl.getNormal(new Point(0, 0, 2)), "Cylinder top center normal is wrong");

        // BV02: Point at the center of the bottom base (p0)
        assertEquals(new Vector(0, 0, -1), cyl.getNormal(new Point(0, 0, 0)), "Cylinder bottom center normal is wrong");
    }
}