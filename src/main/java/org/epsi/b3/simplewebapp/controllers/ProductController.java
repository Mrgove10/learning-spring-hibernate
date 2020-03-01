package org.epsi.b3.simplewebapp.controllers;

import org.epsi.b3.simplewebapp.products.Product;
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

    @RequestMapping(path = "/createProduct", method = {GET, POST})
    public ModelAndView CreateProductMethod (@ModelAttribute Product p) {
        // TODO : implemente me
        // On prend le produit renvoyer par le formulaire
        // On cree un nouveau bean
        // On met se bean en base de donne en utilisant la class DBUtils
        // on met le novelle objet dans la vue
        // on afiche la vue avec ce nouvelle objet dedans
        return null;
    }

    @RequestMapping(path = "/deleteProduct", method = { POST})
    public Object DeleteProductMethod (@RequestParam String id) {
        // TODO : implemente me
        // On cherche l'id du produit qui nous est encvyer dfans les parametre .
        // on recupere le produit avec DBUtils
        // on le suprime avec DBUtils
        return null;
    }

    @RequestMapping(path = "/editProduct", method = {GET, POST})
    public Object EditProductMethod (@RequestParam String id) {
        // TODO : implemente me
        // On cherche l'id du produit qui nous est encvyer dfans les parametre .
        // on recupere le produit avec DBUtils
        // on le suprime avec DBUtils
        return null;
    }

    @RequestMapping(path = "/productList", method = {GET})
    public ModelAndView ProductListMethod () {
        // TODO : implemente me
        // Grace a Dbutils on recupere la list de tout les produit
        // on insert cette list dans la vue
        // on renvoie la vue
        return null;
    }
}
