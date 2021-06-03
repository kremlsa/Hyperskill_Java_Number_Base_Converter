package converter;

import java.math.BigDecimal;

public class Converter {

    public String conv(int oldradix, String numberString, int radix) {
        String converted;
        StringBuilder convertFract = new StringBuilder();

        long integerPart;
        if (numberString.contains(".")) {


            String[] arr = numberString.split("\\.");

            integerPart = Long.parseLong(arr[0], oldradix);
            //int fractPart = Integer.parseInt(arr[1]);
            int fractPart = 0;
            double multiply = 0.0;

            if (oldradix != 10) {
                int[] digits = new int[arr[1].length()];
                for (int i = 0; i <= arr[1].length() - 1; i++) {
                    digits[i] = Character.getNumericValue(arr[1].charAt(i));
                    multiply += digits[i] / Math.pow(oldradix, i + 1);

                }

            }
            else {
                multiply = Double.parseDouble("0." + arr[1]);
                //System.out.println(multiply);
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
        } else {
            if (oldradix != 1) {
                integerPart = Long.parseLong(numberString, oldradix);
            } else {
                integerPart = Long.parseLong(numberString);
            }
        }

        if (oldradix != 1 && radix != 1) {
            converted = Long.toString(integerPart, radix);
//            System.out.println(converted + "." + convertFract);
            String dot = convertFract.toString().length() > 0 ? "." : "";
            return converted + dot + convertFract;
        } else if (oldradix != 1 && radix == 1) {
            StringBuilder newOne = new StringBuilder();
            for (int i = 0; i < integerPart; i++) {
                newOne.append("1");
            }
            //System.out.println(newOne + "." + convertFract);
            //System.out.println(newOne);
            return newOne.toString();

        } else if (oldradix == 1 && radix != 1) {
            converted = Integer.toString(String.valueOf(integerPart).length(), radix);
            //System.out.println(converted + "." + convertFract);
            return converted + "." + convertFract;
        }
        return "";

    }
}
