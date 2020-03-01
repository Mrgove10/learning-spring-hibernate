package org.epsi.b3.simplewebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserAccountController {

    @RequestMapping(path = "/login", method = {RequestMethod.POST})
    public ModelAndView myActionMethod(){

     ModelAndView result = new ModelAndView("loginView");
    //result.addObject(“myInstance”, myEntityInstance);
     return result;
    }

}
