package geometries.api;

import primitives.Point;
import primitives.Vector;

/**
 * Interface for all geometric objects in the 3D space.
 * @author Your Name
 */
public interface Geometry {

    /**
     * Calculates the normal vector to the geometry at a given point.
     * @param point The point on the geometry surface
     * @return The normal vector (unit vector)
     */
    Vector getNormal(Point point);
}