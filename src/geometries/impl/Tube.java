package geometries.impl;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Class representing a tube in 3D space.
 *
 * @author Gemini
 */
public class Tube extends RadialGeometry {
    protected final Ray _axis;

    /**
     * Constructor to initialize the tube.
     *
     * @param radius the radius of the tube
     * @param axis   the axis ray of the tube
     */
    public Tube(double radius, Ray axis) {
        super(radius);
        this._axis = axis;
    }

    @Override
    public Vector getNormal(Point point) {
        // 1. P0 is the head of the axis ray
        Point p0 = _axis.head();
        // 2. v is the direction of the axis ray
        Vector v = _axis.direction();

        // 3. w = P - P0
        Vector w = point.subtract(p0);

        // 4. t = v * w (dot product)
        double t = v.dotProduct(w);

        // 5. O = P0 + t * v
        Point o = p0; // Starting at P0
        if (t != 0) { // If t is not zero, move to O
            o = p0.add(v.scale(t));
        }

        // 6. Normal = P - O
        return point.subtract(o).normalize();
    }
}