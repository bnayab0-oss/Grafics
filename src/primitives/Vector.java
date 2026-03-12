package primitives;

/**
 * Class Vector represents a direction and magnitude in 3D space.
 * The class inherits from Point.
 */
public class Vector extends Point {

    /**
     * Constructor to initialize Vector based on three double values.
     * @param x first coordinate
     * @param y second coordinate
     * @param z third coordinate
     * @throws IllegalArgumentException if the vector is (0,0,0)
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not allowed");
        }
    }

    /**
     * Constructor to initialize Vector based on a Double3 object.
     * @param xyz Double3 value for the coordinates
     * @throws IllegalArgumentException if the vector is (0,0,0)
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not allowed");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Vector: " + _xyz;
    }

    /**
     * Adds another vector to this vector.
     * @param other the other vector
     * @return a new Vector which is the sum of both
     */
    public Vector add(Vector other) {
        return new Vector(_xyz.add(other._xyz));
    }

    /**
     * Multiplies the vector by a scalar.
     * @param scalar the scaling factor
     * @return a new scaled Vector
     */
    public Vector scale(double scalar) {
        return new Vector(_xyz.scale(scalar));
    }

    /**
     * Calculates the dot product between two vectors.
     * @param other the other vector
     * @return the scalar result of the dot product
     */
    public double dotProduct(Vector other) {
        return _xyz._d1 * other._xyz._d1 +
                _xyz._d2 * other._xyz._d2 +
                _xyz._d3 * other._xyz._d3;
    }

    /**
     * Calculates the cross product between two vectors.
     * @param other the other vector
     * @return a new Vector perpendicular to both given vectors
     */
    public Vector crossProduct(Vector other) {
        double x1 = _xyz._d1, y1 = _xyz._d2, z1 = _xyz._d3;
        double x2 = other._xyz._d1, y2 = other._xyz._d2, z2 = other._xyz._d3;

        return new Vector(
                y1 * z2 - z1 * y2,
                z1 * x2 - x1 * z2,
                x1 * y2 - y1 * x2
        );
    }

    /**
     * Calculates the squared length of the vector.
     * @return the squared length
     */
    public double lengthSquared() {
        return dotProduct(this);
    }

    /**
     * Calculates the length of the vector.
     * @return the length
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes the vector to have a length of 1.
     * @return a new normalized Vector
     */
    public Vector normalize() {
        return scale(1 / length());
    }
}