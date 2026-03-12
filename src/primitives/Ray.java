package primitives;

import java.util.Objects;

/**
 * Class Ray represents a semi-line in 3D space, defined by an origin point and a direction vector.
 */
public class Ray {
    /** The starting point of the ray */
    private final Point _head;
    /** The direction of the ray (normalized) */
    private final Vector _direction;

    /**
     * Constructor to initialize a Ray with an origin point and a direction vector.
     * The direction vector is automatically normalized.
     * * @param head the origin point [cite: 105]
     * @param direction the direction vector [cite: 105]
     */
    public Ray(Point head, Vector direction) {
        _head = head;
        _direction = direction.normalize();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // [cite: 439, 442]
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
        return "Ray: origin=" + _head + ", direction=" + _direction;
    }
}