package geometries.impl;

import geometries.api.Geometry;
import primitives.Point;
import primitives.Vector;

/**
 * Class representing a plane in 3D space.
 *
 * @author Gemini
 */
public class Plane extends Geometry {
    private final Point _point;
    private final Vector _normal;

    /**
     * Constructor to initialize the plane from three points.
     * At this stage, only the point is saved (partial implementation).
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    public Plane(Point p1, Point p2, Point p3) {
        this._point = p1;
        this._normal = null; // To be implemented in later stages
    }

    /**
     * Constructor to initialize the plane from a point and a normal vector.
     * The normal vector is normalized before being saved.
     *
     * @param point  a point on the plane
     * @param normal the normal vector to the plane
     */
    public Plane(Point point, Vector normal) {
        this._point = point;
        this._normal = normal.normalize();
    }

    @Override
    public Vector getNormal(Point point) {
        return _normal;
    }
}