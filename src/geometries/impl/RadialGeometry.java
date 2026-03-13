package geometries.impl;

import geometries.api.Geometry;

/**
 * Abstract class for all geometric shapes with a radius.
 * This class serves as a base for geometries like Sphere, Tube, and Cylinder.
 * * @author Gemini
 */
public abstract class RadialGeometry extends Geometry {
    /**
     * The radius of the geometry
     */
    protected final double _radius;

    /**
     * The square of the radius, pre-calculated for performance (DRY principle)
     */
    protected final double _radiusSquared;

    /**
     * Constructor to initialize the radius and its square.
     * * @param radius the radius of the geometry
     */
    public RadialGeometry(double radius) {
        this._radius = radius;
        this._radiusSquared = radius * radius;
    }

    // No getters or setters are defined at this stage per instructions
}