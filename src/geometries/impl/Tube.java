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
        return null; // Temporary implementation
    }
}