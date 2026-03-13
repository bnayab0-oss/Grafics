package geometries.impl;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Class representing a cylinder in 3D space.
 *
 * @author Gemini
 */
public class Cylinder extends Tube {
    private final double _height;

    /**
     * Constructor to initialize the cylinder.
     *
     * @param radius the radius of the cylinder
     * @param axis   the axis ray of the cylinder
     * @param height the height of the cylinder
     */
    public Cylinder(double radius, Ray axis, double height) {
        super(radius, axis);
        this._height = height;
    }

    @Override
    public Vector getNormal(Point point) {
        return null; // Temporary implementation
    }
}