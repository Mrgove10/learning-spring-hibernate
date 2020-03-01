package org.epsi.b3.simplewebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class UserAccountController {

    @RequestMapping(path = "/login", method = {POST})
    public Object myActionMethod() {
        // TODO : implemente me
        // on recupere les info du formulaire
        // on cherche l'utiliosateur avec les methode dans DBUtils
        // on verrifie que l'utilisateur existe bien
        // on cree une session pour l'utilisateur puis on le connect
        return null;
    }

    @RequestMapping(path = "/userInfo", method = {POST, GET})
    public ModelAndView UserInfoMethod(@RequestParam String paramA) {
        // on recupere l'id de lutiliosateur dans la requete
        // on recupere le user grace a cette ID et avec DBUtils
        // on ajoute le model de l'utilisateur a la vie
        // on retourne la vue au user qui a fait la requete
        return null;
    }

}
