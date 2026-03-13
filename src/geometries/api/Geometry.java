package geometries.api;

import primitives.Point;
import primitives.Vector;

/**
 * Abstract class representing a geometric body in 3D space.
 * All geometries must implement getNormal method.
 */
public abstract class Geometry {
    /**
     * Calculates the normal vector to the geometry at a given point.
     *
     * @param point The point on the geometry surface
     * @return The normal vector
     */
    public abstract Vector getNormal(Point point);
}