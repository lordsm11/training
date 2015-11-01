package tn.med.utility;

import java.math.BigDecimal;

public class DecimalUtils {

    private DecimalUtils() {

    }

    public static BigDecimal convertToBigDecimal(String number) {
        try {
            return new BigDecimal(number);
        }catch (NumberFormatException e){
            return BigDecimal.ZERO;
        }
    }

}
