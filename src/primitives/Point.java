package primitives;

import java.util.Objects;

/**
 * Class Point is the basic class representing a point with 3 coordinates in the 3D space.
 * All operations on points return new objects (Immutable).
 * * @author Your Name
 */
public class Point {
    /**
     * Coordinates of the point in 3D space.
     */
    protected final Double3 _xyz;

    /**
     * Static constant for the origin point (0,0,0).
     */
    public static final Point ZERO = new Point(Double3.ZERO);

    /**
     * Constructor to initialize Point based on three double values.
     * * @param x first coordinate
     * @param y second coordinate
     * @param z third coordinate
     */
    public Point(double x, double y, double z) {
        _xyz = new Double3(x, y, z);
    }

    /**
     * Constructor to initialize Point based on a Double3 object.
     * * @param xyz Double3 value for the coordinates
     */
    public Point(Double3 xyz) {
        _xyz = xyz;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; [cite: 442]
        if (obj == null || getClass() != obj.getClass()) return false; [cite: 443, 444]
        Point other = (Point) obj;
        return _xyz.equals(other._xyz); [cite: 446]
    }

    @Override
    public int hashCode() {
        return _xyz.hashCode(); [cite: 446]
    }

    @Override
    public String toString() {
        return "Point: " + _xyz;
    }

    /**
     * Subtracts one point from another to create a vector.
     * * @param other the point to subtract
     * @return a new Vector from the other point to this point
     */
    public Vector subtract(Point other) {
        return new Vector(_xyz.subtract(other._xyz)); [cite: 81]
    }

    /**
     * Adds a vector to the point to create a new point.
     * * @param vector the vector to add
     * @return a new Point after the move
     */
    public Point add(Vector vector) {
        return new Point(_xyz.add(vector._xyz)); [cite: 81]
    }

    /**
     * Calculates the squared distance between two points.
     * * @param other the other point
     * @return the squared distance
     */
    public double distanceSquared(Point other) {
        double x1 = _xyz._d1;
        double y1 = _xyz._d2;
        double z1 = _xyz._d3;

        double x2 = other._xyz._d1;
        double y2 = other._xyz._d2;
        double z2 = other._xyz._d3;

        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2); [cite: 81]
    }

    /**
     * Calculates the distance between two points using distanceSquared.
     * * @param other the other point
     * @return the distance
     */
    public double distance(Point other) {
        return Math.sqrt(distanceSquared(other)); [cite: 82, 499, 500]
    }
}