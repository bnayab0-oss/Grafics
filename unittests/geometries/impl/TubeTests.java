package geometries.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import primitives.*;

class TubeTests {

    @Test
    void testGetNormal() {
        // ציר הצינור הוא ציר ה-Z
        Ray axis = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));

        // תיקון סדר הפרמטרים: רדיוס (1.0) ואז הקרן (axis)
        Tube tube = new Tube(1.0, axis);

        // ============ Equivalence Partitions Tests =============
        // בדיקה פשוטה - נקודה על דופן הצינור
        Vector n = tube.getNormal(new Point(1, 0, 5));

        assertEquals(new Vector(1, 0, 0), n, "Tube getNormal() wrong result");
        assertEquals(1, n.length(), 0.00001, "Normal length is not 1");
    }
}