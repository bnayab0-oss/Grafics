package geometries.impl;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * Class representing a cylinder in 3D space.
 *
 * @author Gemini
 */
public class Cylinder extends Tube {
    private final double _height;

    /**
     * Constructor to initialize the cylinder.
     *
     * @param radius the radius of the cylinder
     * @param axis   the axis ray of the cylinder
     * @param height the height of the cylinder
     */
    public Cylinder(double radius, Ray axis, double height) {
        super(radius, axis);
        this._height = height;
    }

    @Override
    public Vector getNormal(Point point) {
        Point p0 = _axis.head();
        Vector v = _axis.direction();

        // 1. חישוב t - ההיטל של הנקודה על הציר
        // אנחנו לא יכולים להשתמש ב-subtract אם הנקודה היא בדיוק p0
        double t;
        try {
            t = v.dotProduct(point.subtract(p0));
        } catch (IllegalArgumentException e) {
            // אם point == p0, אז t הוא 0
            return v.scale(-1);
        }

        // 2. בדיקה אם הנקודה על הבסיסים
        if (isZero(t)) // בסיס תחתון
            return v.scale(-1);

        if (isZero(t - _height)) // בסיס עליון
            return v;

        // 3. אם לא על הבסיסים, זה בדיוק כמו ב-Tube
        return super.getNormal(point);
    }
}