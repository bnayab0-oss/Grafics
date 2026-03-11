public record Double3 (double _d1, double _d2, double _d3) {
    public static final Double3 ZERO = new Double3(0, 0, 0);
    public static final Double3 ONE = new Double3(1, 1, 1);

    public Double3(double value) { this(value, value, value); }

    @Override
    public String toString() { return "(" + _d1 + "," + _d2 + "," + _d3 + ")" ; }
    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Double3(double od1, double od2, double od3))// uses Util.isZero()
                && isZero(_d1 - od1)
                && isZero(_d2 - od2)
                && isZero(_d3 - od3);
    }

    @Override
    public int hashCode() { return Objects.hash(_d1, _d2, _d3); }
// … Operations …

    bnaya חחחחח
}