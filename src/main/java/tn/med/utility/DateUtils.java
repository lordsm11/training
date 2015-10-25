package tn.med.utility;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * Created by med on 22/10/15.
 */
public class DateUtils {

    public static String getDayOfWeek (String date){
        //01011912 lundi   29j
        List<String> splits =  Splitter.fixedLength(2).splitToList(date);
        int day = Integer.parseInt(splits.get(0));
        int month = Integer.parseInt(splits.get(1));
        int year = Integer.parseInt(splits.get(2)+splits.get(3));

        int nbYears = year - 1912;
        int nbDays = (nbYears * 365) + (nbYears+3) / 4 + getNbDAysInYear(year,month,day);

        return getDayOfWeek(nbDays);

    }

    private static String getDayOfWeek(int nbDays) {
        String daysMapStr = "1:LUNDI,2:MARDI,3:MERCREDI,4:JEUDI,5:VENDREDI,6:SAMEDI,0:DIMANCHE";
        Map<String,String> daysMap = Splitter.on(",").withKeyValueSeparator(":").split(daysMapStr);
        return daysMap.get(String.valueOf(nbDays % 7));
    }

    private static int getNbDAysInYear(int year,int month,int day) {
        String monthMapStr = "1:0,2:31,3:59,4:90,5:120,6:151,7:181,8:212,9:243,10:273,11:304,12:334";
        Map<String,String> monthMap = Splitter.on(",").withKeyValueSeparator(":").split(monthMapStr);
        return day + Integer.parseInt(monthMap.get(String.valueOf(month)))+ (year % 4 == 0 ? 1:0);
    }
}
