package tn.med.utility;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DecimalUtilsTest {
    @Test
    public void testConvertToBigDecimal() throws Exception {
        assertThat(DecimalUtils.convertToBigDecimal(""),is(BigDecimal.ZERO));
        assertThat(DecimalUtils.convertToBigDecimal("1.25").compareTo(BigDecimal.valueOf(1.25d)),is(0));
    }

}
