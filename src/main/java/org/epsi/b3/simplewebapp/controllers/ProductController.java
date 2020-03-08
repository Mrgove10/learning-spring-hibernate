package org.epsi.b3.simplewebapp.controllers;

import org.epsi.b3.simplewebapp.db.utils.DBUtils;
import org.epsi.b3.simplewebapp.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ProductController {

    @RequestMapping(path = "/createProduct", method = {GET, POST})
    public ModelAndView CreateProductMethod(@ModelAttribute Product p) {
        //on cree un nuouveau bean
        Product ppp = new Product();
        ppp.setName(p.getName());
        ppp.setCode(p.getCode());
        ppp.setPrice(p.getPrice());
        //on insert lea bean en bdd
        DBUtils.insertProduct(ppp);
        // on afiche la vue avec ce nouvelle objet dedans
        ModelAndView mav = new ModelAndView();
        mav.addObject("product", ppp);
        return mav;
    }

    @RequestMapping(path = "/deleteProduct", method = {POST})
    public Object DeleteProductMethod(@RequestParam String id) {
        //on supprime le product
        DBUtils.deleteProduct(id);
        return null;
    }

    @RequestMapping(path = "/editProduct", method = {GET, POST})
    public Object EditProductMethod(@RequestParam String id, @ModelAttribute Product p) {
        //on cree un nouveau bean
        Product ppp = new Product();
        ppp.setName(p.getName());
        ppp.setCode(p.getCode());
        ppp.setPrice(p.getPrice());
        //on met a jour le produit
        DBUtils.updateProduct(ppp);

        // on retourne le poduit
        return ppp;
    }

    @RequestMapping(path = "/productList", method = {GET})
    public ModelAndView ProductListMethod() {
        List<Product> products = DBUtils.queryProduct();
        ModelAndView mav = new ModelAndView();
        mav.addObject("productList", products);
        mav.setViewName("productlist");
        return mav;

    }
}
