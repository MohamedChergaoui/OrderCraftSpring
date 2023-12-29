package com.exemple.controller;

import com.exemple.entity.User;
import com.exemple.service.User.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Scope("session")
@RequestMapping(value = "/Users"  )
public class ListController {
    @Autowired
    private InterfaceUserService interfaceUserService;

    @GetMapping
    public String list(ModelMap modelMap)
    {List<User> users = interfaceUserService.getUsers();
        modelMap.addAttribute("users", users);
        return "User/Users";
    }
    @GetMapping("/Modifier" )
    public String ModUser(long id , Model model){
        User user = interfaceUserService.GitUserById(id);
        model.addAttribute("user",user);


        return "/User/Edit";
    }
    @PostMapping("/Save")
    public String ModUser(long id ,String nom,String Prenom, String email,String password,String role){

         interfaceUserService.ModUser(id,nom,Prenom,password,role,email);

        return "redirect:/Users";
    }
    @GetMapping("/Delete")
    public String ModUser(long id){

        interfaceUserService.DeleUser(id);

        return "redirect:/Users";
    }
    @GetMapping("/Add")
    public String ModUser(){
        return "User/AddUser";
    }
    @PostMapping("/Add")
    public String ModUser( String nom,String Prenom, String email,String password,String role){

        interfaceUserService.AddUser(nom,Prenom,password,role,email);

        return "redirect:/Users";
    }
}
