package tn.med.controller;

import com.google.appengine.api.log.LogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tn.med.model.dto.ImpotForm;
import tn.med.model.dto.SimulationImpotDto;
import tn.med.service.ImpotsService;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value="impots")
public class ImpotsController {

    private static final Logger log = Logger.getLogger(ImpotsController.class.getName());

    @Autowired
    private ImpotsService impotsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("impots", "impotForm", new ImpotForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("impotForm") ImpotForm impot) {
        log.setLevel(Level.INFO);
        log.info("impotForm : " + impot.toString());
        ModelAndView model = new ModelAndView("impots");
        model.addObject("simulationImpot",impotsService.calculateImpots(impot));
        return model;
    }

}