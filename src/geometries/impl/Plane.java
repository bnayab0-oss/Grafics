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
// 1. יוצרים שני וקטורים על המישור (בעזרת הפרימיטיבים שלנו)
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

        // 2. משתמשים במכפלה וקטורית כדי למצוא וקטור שמאונך לשניהם
        // ואז מנרמלים אותו. זה הנורמל של המישור!
        this._normal = v1.crossProduct(v2).normalize();    }

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