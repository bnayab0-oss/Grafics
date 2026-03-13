package geometries.impl;

import primitives.Point;
import primitives.Vector;

/**
 * Class representing a triangle in 3D space.
 *
 * @author Gemini
 */
public class Triangle extends Polygon {
    /**
     * Constructor to initialize the triangle from three vertices.
     *
     * @param p1 first vertex
     * @param p2 second vertex
     * @param p3 third vertex
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    @Override
    public Vector getNormal(Point point) {
        return null; // Temporary implementation
    }
}