package tn.med;

import tn.med.utility.DateUtils;
import tn.med.utility.StringUtils;

public class Principale {

    public static void main(String[] args) {
        System.out.println(DateUtils.getDayOfWeek("01012012"));
        System.out.println(DateUtils.getDayOfWeek("18102015"));
        System.out.println(DateUtils.getDayOfWeek("08081985"));
        System.out.println(StringUtils.formatPhoneNumber("0673205166"));
    }

}
