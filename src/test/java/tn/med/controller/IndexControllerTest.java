package tn.med.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations ={"classpath:spring-context.xml"})
public class IndexControllerTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private IndexController indexController;

    @Test
    public void testGet() throws Exception {
        assertThat(indexController.get(),is("index"));
    }
}
