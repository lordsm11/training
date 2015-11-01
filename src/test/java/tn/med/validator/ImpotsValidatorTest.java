package tn.med.validator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.validation.BeanPropertyBindingResult;
import tn.med.model.dto.ImpotForm;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations ={"classpath:spring-context.xml"})
public class ImpotsValidatorTest extends AbstractJUnit4SpringContextTests {

    @InjectMocks
    @Autowired
    private ImpotsValidator impotsValidator;

    @Mock
    private Errors errors;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateWhenCelibataire() throws Exception {
        ImpotForm impot = new ImpotForm();
        impot.setOnePart(0);
        impot.setAmount1("dd");
        impot.setAmount2("110");
        impot.setNbChildren(2);
        impot.setDeductions("100");
        Errors errors = new Errors(impot,"amount1");
        impotsValidator.validate(impot, errors);
        assertThat(errors.getResults().size(),is(3));
        assertThat(errors.getResults().get(0),is("amount1 mad.impot.amount.not.number"));
        assertThat(errors.getResults().get(1),is("amount2 mad.impot.amount.not.null"));
        assertThat(errors.getResults().get(2),is("nbChildren mad.impot.amount.not.number"));

    }

    @Test
    public void testValidateWhenMarie() throws Exception {
        ImpotForm impot = new ImpotForm();
        impot.setOnePart(1);
        impot.setAmount1("-1");
        impot.setAmount2(null);
        impot.setNbChildren(3);
        impot.setDeductions("-100");
        Errors errors = new Errors(impot,"amount2");
        impotsValidator.validate(impot, errors);
        assertThat(errors.getResults().size(),is(3));
        assertThat(errors.getResults().get(0),is("amount1 mad.impot.amount.not.number"));
        assertThat(errors.getResults().get(1),is("amount2 mad.impot.amount.null"));
        assertThat(errors.getResults().get(2),is("deductions mad.impot.amount.not.number"));
    }

    class Errors extends BeanPropertyBindingResult{

        private List<String> results = new ArrayList<String>();

        @Override
        public void rejectValue(java.lang.String s, java.lang.String s1) {
            results.add(s+" "+s1);
        }

        public Errors(Object target, String objectName) {
            super(target, objectName);
        }
        public Errors(Object target, String objectName, boolean autoGrowNestedPaths, int autoGrowCollectionLimit) {
            super(target, objectName, autoGrowNestedPaths, autoGrowCollectionLimit);
        }

        public List<String> getResults() {
            return results;
        }

        public void setResults(List<String> results) {
            this.results = results;
        }
    }
}
