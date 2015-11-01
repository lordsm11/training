package tn.med.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tn.med.model.dto.ImpotForm;
import tn.med.service.ImpotsService;
import tn.med.validator.ImpotsValidator;

@Controller
@RequestMapping(value="impots")
public class ImpotsController {

    @Autowired
    private ImpotsService impotsService;

    @Autowired
    private ImpotsValidator impotsValidator;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("impots", "impotForm", new ImpotForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("impotForm")ImpotForm impot, BindingResult bindingResult) {
        impotsValidator.validate(impot, bindingResult);

        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("impots");
        }
        return new ModelAndView("impotsResultat","simulationImpot",impotsService.calculateImpots(impot));
    }

}