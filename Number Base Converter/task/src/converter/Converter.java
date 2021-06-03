package converter;

public class Converter {

    public String conv(int oldRadix, String numberString, int radix) {
        long number = Long.parseLong(numberString, oldRadix);
        return Long.toString(number, radix);
    }
}
