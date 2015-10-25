package tn.med.utility;

import java.math.BigDecimal;

public class DecimalUtils {

    public static BigDecimal convertToBigDecimal(String number) {
        try {
            return new BigDecimal(number);
        }catch (NumberFormatException e){
            return BigDecimal.ZERO;
        }
    }

    public static Integer convertToInteger(String number) {
        try {
            return new Integer(number);
        }catch (NumberFormatException e){
            return 0;
        }
    }

}
