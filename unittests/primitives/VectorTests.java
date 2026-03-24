package primitives;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for primitives.Vector class
 */
class VectorTests {

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    void testAdd() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple vector addition
        Vector v2 = new Vector(-2, -4, -6);
        assertEquals(new Vector(-1, -2, -3), v1.add(v2), "add() wrong result");

        // =============== Boundary Values Tests ==================
        // BV01: Addition that results in the zero vector
        assertThrows(IllegalArgumentException.class,
                () -> v1.add(new Vector(-1, -2, -3)),
                "add() for opposite vectors does not throw exception");
    }

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests =============
        // EP01: Simple dot product
        Vector v2 = new Vector(-2, -4, -6);
        assertEquals(-28d, v1.dotProduct(v2), 0.00001, "dotProduct() wrong result");

        // =============== Boundary Values Tests ==================
        // BV01: Dot product of orthogonal vectors (should be 0)
        Vector v3 = new Vector(0, 3, -2);
        assertEquals(0d, v1.dotProduct(v3), 0.00001, "dotProduct() for orthogonal vectors is not zero");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests =============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // EP01: Check length of cross product
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // EP02: Check orthogonality to its operands
        assertEquals(0d, vr.dotProduct(v1), 0.00001, "crossProduct() result not orthogonal to v1");
        assertEquals(0d, vr.dotProduct(v2), 0.00001, "crossProduct() result not orthogonal to v2");

        // =============== Boundary Values Tests ==================
        // BV01: Cross product of parallel vectors (should throw exception due to Zero Vector)
        Vector v3 = new Vector(2, 4, 6);
        assertThrows(IllegalArgumentException.class,
                () -> v1.crossProduct(v3),
                "crossProduct() for parallel vectors does not throw exception");
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @Test
    void testLengthSquared() {
        // ============ Equivalence Partitions Tests =============
        // EP01: Simple length squared
        assertEquals(14d, new Vector(1, 2, 3).lengthSquared(), 0.00001, "lengthSquared() wrong result");
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @Test
    void testLength() {
        // ============ Equivalence Partitions Tests =============
        // EP01: Simple length
        assertEquals(5d, new Vector(0, 3, 4).length(), 0.00001, "length() wrong result");
    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @Test
    void testNormalize() {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();

        // ============ Equivalence Partitions Tests =============
        // EP01: Check that the result is a unit vector
        assertEquals(1d, u.length(), 0.00001, "normalize() result is not a unit vector");

        // EP02: Check that the vectors are parallel (cross product is zero)
        assertThrows(IllegalArgumentException.class,
                () -> v.crossProduct(u),
                "normalize() result is not parallel to original vector");

        // EP03: Check that it's in the same direction (dot product > 0)
        assertTrue(v.dotProduct(u) > 0, "normalize() result is in opposite direction");
    }
}