package tn.med.utility;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class StringUtils {

    public static String formatPhoneNumber (String number){
        return Joiner.on(" ").skipNulls().join(Splitter.fixedLength(2).split(number));
    }

}
