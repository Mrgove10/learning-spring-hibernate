package org.epsi.b3.simplewebapp.controllers;

import org.epsi.b3.simplewebapp.db.utils.DBUtils;
import org.epsi.b3.simplewebapp.users.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class UserAccountController {

    @RequestMapping(path = "/login", method = {POST})
    public Object myActionMethod(@ModelAttribute UserAccount u) {
        UserAccount tmpUser = DBUtils.findUser(u.getUserName(), u.getPassword());
        // cree une session
        return tmpUser != null;
    }

    @RequestMapping(path = "/userInfo", method = {POST, GET})
    public ModelAndView UserInfoMethod(@RequestParam String userid) {
        UserAccount tmpuser = DBUtils.findUser(userid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", tmpuser);
        return mav;
    }
}
