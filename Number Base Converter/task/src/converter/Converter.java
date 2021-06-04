package converter;

public class Converter {

    public String conv(int oldRadix, String numberString, int radix) {

        if(!numberString.contains(".")) {
            long number = Long.parseLong(numberString, oldRadix);
            return Long.toString(number, radix);
        } else {
            long integerPart;
            String converted = "";
            StringBuilder convertFract = new StringBuilder();
            String[] arr = numberString.split("\\.");
            integerPart = Long.parseLong(arr[0], oldRadix);
            int fractPart = 0;
            double multiply = 0.0;

            if (oldRadix != 10) {
                int[] digits = new int[arr[1].length()];
                for (int i = 0; i <= arr[1].length() - 1; i++) {
                    digits[i] = Character.getNumericValue(arr[1].charAt(i));
                    multiply += digits[i] / Math.pow(oldRadix, i + 1);
                }
            }
            else {
                multiply = Double.parseDouble("0." + arr[1]);
            }
            double mult = multiply;

            int integerPartF;
            String multString = "";

            for (int i = 0; i < 5; i++) {
                mult *= radix;
                multString = Double.toString(mult);
                String[] arr2 = multString.split("\\.");
                integerPartF = Integer.parseInt(arr2[0]);
                mult = Double.parseDouble("0." + arr2[1]);
                convertFract.append(String.valueOf(Character.forDigit(integerPartF, 36)));
            }

            converted = Long.toString(integerPart, radix);
            return converted + "." + convertFract;
        }
    }
}
