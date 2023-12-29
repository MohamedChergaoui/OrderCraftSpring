package com.exemple.controller;

import com.exemple.entity.User;
import com.exemple.service.Login.ILogin;
import com.mysql.cj.NativeQueryAttributesBindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/"  )
@Controller
public class WelcomeController {

    @Autowired
    ILogin LoginUser;

   @GetMapping
    public String welcome()
    {
        return "welcome";
    }
    @RequestMapping(value = "Login", method = RequestMethod.POST)
    public String Login(String email, String password , Model model,HttpSession session){
       if(LoginUser.Login(email,password)!=null){
           User user =LoginUser.Login(email,password);
           model.addAttribute("user",user);
           Long id =user.getId();
           session.setAttribute("userLogin", user);

           return "redirect:/Users?id=" + id;
       }
       return "welcome";


    }
    @RequestMapping(value = "Logout", method=RequestMethod.GET)
    public String Logout(HttpSession session){
       System.out.println("raja");
        session.invalidate();
       return "redirect:/";
    }
}
