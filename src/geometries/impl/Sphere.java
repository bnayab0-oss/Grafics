package geometries.impl;

import primitives.Point;
import primitives.Vector;

/**
 * Class representing a sphere in 3D space.
 *
 * @author Gemini
 */
public class Sphere extends RadialGeometry {
    private final Point _center;

    /**
     * Constructor to initialize the sphere.
     * Order changed to (Point, double) to match Main.java requirements.
     *
     * @param center the center point of the sphere
     * @param radius the radius of the sphere
     */
    public Sphere(Point center, double radius) {
        super(radius);
        this._center = center;
    }

    @Override
    public Vector getNormal(Point point) {
        return null; // Temporary implementation for Stage 1 [cite: 544]
    }
}