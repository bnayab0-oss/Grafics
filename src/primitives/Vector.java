package primitives;

/**
 * Class representing a vector in 3D space.
 * Inherits from Point and adds vector-specific operations.
 *
 * @author Gemini
 */
public final class Vector extends Point {
    /**
     * Static constants for axis vectors (required by Main)
     */
    public static final Vector AXIS_X = new Vector(1, 0, 0);
    public static final Vector AXIS_Y = new Vector(0, 1, 0);
    public static final Vector AXIS_Z = new Vector(0, 0, 1);

    /**
     * Constructor to initialize the vector with three double values.
     * Throws IllegalArgumentException if the vector is the zero vector.
     *
     * @param x coordinate on X axis
     * @param y coordinate on Y axis
     * @param z coordinate on Z axis
     * @throws IllegalArgumentException if vector is (0,0,0)
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not allowed");
        }
    }

    /**
     * Constructor to initialize the vector with a Double3 object.
     * Throws IllegalArgumentException if the vector is the zero vector.
     *
     * @param xyz the Double3 coordinate
     * @throws IllegalArgumentException if vector is (0,0,0)
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not allowed");
        }
    }

    /**
     * Adds another vector to this vector.
     *
     * @param other the vector to add
     * @return a new vector which is the sum of both
     */
    public Vector add(Vector other) {
        return new Vector(this._xyz.add(other._xyz));
    }

    /**
     * Scales the vector by a scalar value.
     *
     * @param scalar the scaling factor
     * @return a new scaled vector
     */
    public Vector scale(double scalar) {
        return new Vector(this._xyz.scale(scalar));
    }

    /**
     * Calculates the dot product of this vector and another.
     *
     * @param other the other vector
     * @return the result of the dot product
     */
    public double dotProduct(Vector other) {
        Double3 res = this._xyz.product(other._xyz);
        return res._d1() + res._d2() + res._d3();
    }

    /**
     * Calculates the cross product of this vector and another.
     * Uses the formula: (y1*z2 - z1*y2, z1*x2 - x1*z2, x1*y2 - y1*x2)
     *
     * @param other the other vector
     * @return a new vector which is the cross product
     */
    public Vector crossProduct(Vector other) {
        double x1 = this._xyz._d1();
        double y1 = this._xyz._d2();
        double z1 = this._xyz._d3();

        double x2 = other._xyz._d1();
        double y2 = other._xyz._d2();
        double z2 = other._xyz._d3();

        return new Vector(
                y1 * z2 - z1 * y2,
                z1 * x2 - x1 * z2,
                x1 * y2 - y1 * x2
        );
    }

    /**
     * Calculates the squared length of the vector.
     *
     * @return the squared length
     */
    public double lengthSquared() {
        return this.distanceSquared(Point.ZERO);
    }

    /**
     * Calculates the length of the vector.
     * Uses lengthSquared (DRY principle).
     *
     * @return the length
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes the vector.
     *
     * @return a new unit vector in the same direction
     */
    public Vector normalize() {
        double len = length();
        // Multiplication by 1/len is equivalent to division by len
        return new Vector(this._xyz.scale(1 / len));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Vector:" + _xyz;
    }
}