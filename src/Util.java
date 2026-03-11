public final class Util {
    // It is binary, equivalent to ~1/1,000,000 in decimal (6 digits)
    private static final int ACCURACY = -40;
// double store format: seee eeee eeee (1.)mmmm … mmmm
// 1 bit sign, 11 bits exponent, 53 bits (52 stored) normalized mantissa
private static int getExp(double num) {
return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;}
    public static boolean isZero(double number) {
        return getExp(number) < ACCURACY;
    }
    public static double alignZero(double number) {
        return isZero(number) ? 0.0 : number;
    }
    ... and more ...
}

