package tn.med.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tn.med.model.dto.ImpotForm;

@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "index";
    }

}