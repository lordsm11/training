package tn.med.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import tn.med.model.dto.ImpotForm;
import tn.med.model.dto.SimulationImpotDto;
import tn.med.service.ImpotsService;
import tn.med.validator.ImpotsValidator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(locations ={"classpath:spring-context.xml"})
public class ImpotsControllerTest extends AbstractJUnit4SpringContextTests {

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    @Autowired
    private ImpotsController impotsController;

    @Mock
    private ImpotsValidator impotsValidator;

    @Mock
    private ImpotsService impotsService;

    @Test
    public void testGet() throws Exception {
        assertThat(impotsController.get().getViewName(),is("impots"));
    }

    @Test
    public void testPost() throws Exception {
        ImpotForm impot = new ImpotForm();

        BindingResult result = mock(BindingResult.class);

        when(result.hasFieldErrors()).thenReturn(true);
        assertThat(impotsController.post(impot, result).getViewName(), is("impots"));

        when(result.hasFieldErrors()).thenReturn(false);
        SimulationImpotDto simulationImpot = new SimulationImpotDto("112 euros","","","","");
        when(impotsService.calculateImpots(any(ImpotForm.class))).thenReturn(simulationImpot);

        ModelAndView mav = impotsController.post(impot, result);
        assertThat(mav.getViewName(), is("impotsResultat"));
        assertThat(((SimulationImpotDto)mav.getModel().get("simulationImpot")).getAmount(), is("112 euros"));
    }
}
