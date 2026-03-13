package primitives;

import java.util.Objects;

/**
 * Class representing a ray in 3D space.
 * A ray consists of an origin point and a normalized direction vector.
 *
 * @author Gemini
 */
public class Ray {
    private final Point _head;
    private final Vector _direction;

    /**
     * Constructor to initialize the ray.
     * The direction vector is normalized automatically.
     *
     * @param head      the origin point
     * @param direction the direction vector
     */
    public Ray(Point head, Vector direction) {
        this._head = head;
        this._direction = direction.normalize();
    }

    /**
     * Getter for the head of the ray
     *
     * @return the head point
     */
    public Point head() {
        return _head;
    }

    /**
     * Getter for the direction of the ray
     *
     * @return the direction vector
     */
    public Vector direction() {
        return _direction;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ray other = (Ray) obj;
        return _head.equals(other._head) && _direction.equals(other._direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head, _direction);
    }

    @Override
    public String toString() {
        return "Ray: head=" + _head + ", direction=" + _direction;
    }
}