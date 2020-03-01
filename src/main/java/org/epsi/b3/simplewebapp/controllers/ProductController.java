package org.epsi.b3.simplewebapp.controllers;

import org.epsi.b3.simplewebapp.users.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ProductController {
    /**
     * Gets the parameters froma url
     *
     * @param paramA
     * @return
     */
    @RequestMapping(path = "/createMyEntity", method = {GET, POST})
    public Object myUrlMethod(@RequestParam String paramA) {

        return null;
    }

    /**
     * gets the instance of an object
     *
     * @param ua
     * @return
     */
    @RequestMapping(path = "/createMyEntity", method = {GET, POST})
    public Object myActionMethod(@ModelAttribute UserAccount ua) {
        return null;
    }

    /**
     * gets teh complet model
     *
     * @param fullViewModel
     * @return
     */
    @RequestMapping(path = "/createMyEntity", method = {GET, POST})
    public Object myActionMethod(ModelMap fullViewModel) {
        return null;
    }


    /**
     * Generates a jsp view
     *
     * @return
     */
    @RequestMapping(path = "/createMyEntity", method = {GET, POST})
    public ModelAndView myActionMethod() {
        // ModelAndView result = new ModelAndView(“nameOfTheView”);
        //result.addObject(“myInstance”, myEntityInstance);
        // return result;
        return null;
    }
}
