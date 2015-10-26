package tn.med.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import tn.med.model.business.ImpotInfo;
import tn.med.model.business.ImpotInfoBuilder;
import tn.med.model.constants.ImpotEnum;
import tn.med.model.dto.ImpotForm;
import tn.med.model.dto.SimulationImpotDto;
import tn.med.persistance.ImpotsDao;

import java.lang.reflect.Method;
import java.math.BigDecimal;

@ContextConfiguration(locations ={"classpath:spring-context.xml"})
public class ImpotsServiceTest extends AbstractJUnit4SpringContextTests {

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ImpotsDao impotsDao;

    @InjectMocks
    @Autowired
    private ImpotsService impotsService;


    private static BigDecimal TWO = BigDecimal.valueOf(2);

    @Test
    public void calculateImpotsTotalOnePartTest(){
        doNothing().when(impotsDao).saveObject(any(ImpotForm.class), any(ImpotInfo.class), any(BigDecimal.class));
        ImpotForm impotForm = new ImpotForm();
        impotForm.setOnePart(true);
        impotForm.setAmount1("24000");
        impotForm.setDeductions("3000");
        SimulationImpotDto simulationImpotDto = impotsService.calculateImpots(impotForm);
        assertThat(simulationImpotDto.getImpot(),is("1287.86"));
        assertThat(simulationImpotDto.getNbParts(),is("1"));
        assertThat(simulationImpotDto.getTaux(),is("6.81"));
    }

    @Test
    public void calculateImpotsTotalTwoPartsTest(){
        doNothing().when(impotsDao).saveObject(any(ImpotForm.class), any(ImpotInfo.class), any(BigDecimal.class));
        ImpotForm impotForm = new ImpotForm();
        impotForm.setOnePart(false);
        impotForm.setAmount1("24000");
        impotForm.setAmount2("10000");
        impotForm.setDeductions("3000");
        SimulationImpotDto simulationImpotDto = impotsService.calculateImpots(impotForm);
        assertThat(simulationImpotDto.getImpot(),is("1189.72"));
        assertThat(simulationImpotDto.getNbParts(),is("2.0"));
        assertThat(simulationImpotDto.getTaux(),is("4.26"));
    }

    @Test
    public void substractChargesTest() throws Exception{
        assertThat(substractCharges(BigDecimal.valueOf(10000)).doubleValue(), is(9000d));
        assertThat(substractCharges(BigDecimal.valueOf(25000)).doubleValue(), is(22500d));
    }

    @Test
    public void calculateImpotsTest() throws Exception{
        assertThat(calculateImpots(BigDecimal.valueOf(0), BigDecimal.ONE).doubleValue(), is(0d));
        assertThat(calculateImpots(BigDecimal.valueOf(15000), BigDecimal.ONE).doubleValue(), is(741.86d));
        assertThat(calculateImpots(BigDecimal.valueOf(50000), BigDecimal.ONE).doubleValue(), is(9355d));
        assertThat(calculateImpots(BigDecimal.valueOf(100000), BigDecimal.ONE).doubleValue(), is(27453.73d));
        assertThat(calculateImpots(BigDecimal.valueOf(200000), BigDecimal.ONE).doubleValue(), is(70369.41d));
    }

    @Test
    public void calculateImpotsPlageTest() throws Exception {

        assertThat(calculateImpotsPlage(BigDecimal.valueOf(0), ImpotEnum.TRANCHE1, BigDecimal.ONE).doubleValue(), is(0d));
        assertThat(calculateImpotsPlage(BigDecimal.valueOf(15000), ImpotEnum.TRANCHE1, BigDecimal.ONE).doubleValue(), is(741.86d));
        assertThat(calculateImpotsPlage(BigDecimal.valueOf(30000), ImpotEnum.TRANCHE1, BigDecimal.ONE).doubleValue(), is(2392.6d));

        assertThat(calculateImpotsPlage(BigDecimal.valueOf(0), ImpotEnum.TRANCHE1, TWO).doubleValue(), is(0d));
        assertThat(calculateImpotsPlage(BigDecimal.valueOf(15000), ImpotEnum.TRANCHE1,TWO).doubleValue(), is(0d));
        assertThat(calculateImpotsPlage(BigDecimal.valueOf(30000), ImpotEnum.TRANCHE1, TWO).doubleValue(), is(1483.72d));

        assertThat(calculateImpotsPlage(BigDecimal.valueOf(200000), ImpotEnum.TRANCHE4, BigDecimal.ONE).doubleValue(), is(21551.4d));
    }

    private BigDecimal substractCharges(BigDecimal amount)  throws Exception{
        Method method = impotsService.getClass().getDeclaredMethod("substractCharges", BigDecimal.class);
        method.setAccessible(true);
        return (BigDecimal)method.invoke(impotsService,amount);
    }

    private BigDecimal calculateImpots(BigDecimal amount, BigDecimal nbParts)  throws Exception{
        Method method = impotsService.getClass().getDeclaredMethod("calculateImpots", BigDecimal.class, BigDecimal.class);
        method.setAccessible(true);
        return (BigDecimal)method.invoke(impotsService,amount,nbParts);
    }

    private BigDecimal calculateImpotsPlage(BigDecimal amount, ImpotEnum impotEnum, BigDecimal nbParts) throws Exception{
        Method method = impotsService.getClass().getDeclaredMethod("calculateImpotsPlage", BigDecimal.class, ImpotEnum.class, BigDecimal.class);
        method.setAccessible(true);
        return (BigDecimal)method.invoke(impotsService,amount,impotEnum,nbParts);
    }

}
