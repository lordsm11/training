package tn.med.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tn.med.model.dto.ImpotForm;
import tn.med.model.dto.SimulationImpotDto;
import tn.med.service.ImpotsService;

@Controller
@RequestMapping(value="impots")
public class ImpotsController {

    @Autowired
    private ImpotsService impotsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("impots", "impotForm", new ImpotForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("impotForm") ImpotForm impot) {
        ModelAndView model = new ModelAndView("impots");
        model.addObject("simulationImpot",impotsService.calculateImpots(impot));
        return model;
    }

}