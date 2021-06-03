package converter;

public class Converter {

    public String conv(int oldRadix, String numberString, int radix) {

        if (oldRadix == 10) {
            return Long.toString((Long.parseLong(numberString)), radix);
        }
        return String.valueOf(Long.parseLong(numberString, oldRadix));
    }
}
