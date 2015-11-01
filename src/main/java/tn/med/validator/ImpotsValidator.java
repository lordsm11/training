package tn.med.validator;

import com.google.appengine.repackaged.com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.med.model.constants.Keys;
import tn.med.model.dto.ImpotForm;

import java.math.BigDecimal;

@Service
public class ImpotsValidator implements Validator {

    public static final String ATTRIBUTE_AMOUNT1 = "amount1";
    public static final String ATTRIBUTE_AMOUNT2 = "amount2";
    public static final String ATTRIBUTE_DEDUCTIONS = "deductions";
    public static final String ATTRIBUTE_NB_CHILDREN = "nbChildren";

    @Override
    public boolean supports(Class<?> arg0) {
        return ImpotsValidator.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ImpotForm impot = (ImpotForm)object;

        if(Strings.isNullOrEmpty(impot.getAmount1())){
            errors.rejectValue(ATTRIBUTE_AMOUNT1, Keys.IMPOT_AMOUNT_NULL);
        }else {
            validateBigDecimal(impot.getAmount1(),ATTRIBUTE_AMOUNT1,errors);
        }

        if (impot.isCelibataire()) {
            if(!Strings.isNullOrEmpty(impot.getAmount2())){
                errors.rejectValue(ATTRIBUTE_AMOUNT2,Keys.IMPOT_AMOUNT_NOT_NULL);
            }
            if(impot.getNbChildren() != 0){
                errors.rejectValue(ATTRIBUTE_NB_CHILDREN,Keys.IMPOT_AMOUNT_NOT_NUMBER);
            }
        } else {
            if(Strings.isNullOrEmpty(impot.getAmount2())){
                errors.rejectValue(ATTRIBUTE_AMOUNT2,Keys.IMPOT_AMOUNT_NULL);
            }else {
                validateBigDecimal(impot.getAmount2(),ATTRIBUTE_AMOUNT2,errors);
            }
        }

        if(!Strings.isNullOrEmpty(impot.getDeductions())){
            validateBigDecimal(impot.getDeductions(),ATTRIBUTE_DEDUCTIONS,errors);
        }

    }

    private void validateBigDecimal(String value, String input, Errors errors) {
        boolean error = false;
        try {
            BigDecimal amount = new BigDecimal(value);
            if(BigDecimal.ZERO.compareTo(amount) > 0) {
                error = true;
            }
        } catch (NumberFormatException e) {
            error = true;
        }
        if(error) {
            errors.rejectValue(input,Keys.IMPOT_AMOUNT_NOT_NUMBER);
        }

    }
}
