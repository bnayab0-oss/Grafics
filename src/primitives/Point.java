package primitives;

/**
 * Class representing a point in 3D space.
 * The point is defined by a Double3 coordinate.
 *
 * @author Gemini
 */
public class Point {
    /**
     * Static constant for the origin point (0,0,0)
     */
    public static final Point ZERO = new Point(Double3.ZERO);
    /**
     * The coordinate of the point
     */
    protected final Double3 _xyz;

    /**
     * Constructor to initialize the point with three double values.
     *
     * @param x coordinate on X axis
     * @param y coordinate on Y axis
     * @param z coordinate on Z axis
     */
    public Point(double x, double y, double z) {
        this._xyz = new Double3(x, y, z);
    }

    /**
     * Constructor to initialize the point with a Double3 object.
     *
     * @param xyz the Double3 coordinate
     */
    public Point(Double3 xyz) {
        this._xyz = xyz;
    }

    /**
     * Subtracts another point from this point to get a vector.
     *
     * @param other the point to subtract
     * @return a vector from the other point to this point
     */
    public Vector subtract(Point other) {
        return new Vector(this._xyz.subtract(other._xyz));
    }

    /**
     * Adds a vector to this point to create a new point.
     *
     * @param vector the vector to add
     * @return a new point after the move
     */
    public Point add(Vector vector) {
        return new Point(this._xyz.add(vector._xyz));
    }

    /**
     * Calculates the squared distance between two points.
     * Uses the DRY principle and Double3 operations.
     *
     * @param other the other point
     * @return the squared distance
     */
    public double distanceSquared(Point other) {
        Double3 diff = this._xyz.subtract(other._xyz);
        Double3 res = diff.product(diff);
        // הגישה לרכיבי ה-record צריכה להתבצע עם קו תחתי לפי ההגדרה במצגת
        return res._d1() + res._d2() + res._d3();
    }

    /**
     * Calculates the distance between two points.
     * This method must use distanceSquared[cite: 82].
     *
     * @param other the other point
     * @return the distance
     */
    public double distance(Point other) {
        return Math.sqrt(distanceSquared(other));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return _xyz.equals(other._xyz);
    }

    @Override
    public int hashCode() {
        return _xyz.hashCode();
    }

    @Override
    public String toString() {
        return "Point:" + _xyz;
    }
}