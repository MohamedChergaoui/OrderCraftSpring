package com.exemple.controller;

import com.exemple.entity.Client;
import com.exemple.entity.User;
import com.exemple.repository.InterfaceClientRepository;
import com.exemple.service.Client.ClientService;
import com.exemple.service.Client.IClient;
import com.exemple.service.User.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value = "/Clients"  )
public class ClientController {
    @Autowired
    private IClient ClientService;


    @GetMapping
    public String list(ModelMap modelMap)
    {
        List<Client> Clients = ClientService.getCLient();
        System.out.println("raja");
        modelMap.addAttribute("Clients", Clients);
        return "Client/Clients";
    }
    @GetMapping("/Modifier" )
    public String ModClient(long id , Model model){
        Client client = ClientService.GitClientById(id);
        model.addAttribute("client",client);


        return "/Client/Edit";
    }
    @PostMapping("/Save")
    public String ModClient(long id ,String nom,String Prenom, String adresse,String tele){

        ClientService.ModClient(id,nom,Prenom,adresse,tele);

        return "redirect:/Clients";
    }
    @GetMapping("/Delete")
    public String DelClient(long id){

        ClientService.DeleClient(id);

        return "redirect:/Clients";
    }
    @GetMapping("/Add")
    public String AddClient(){
        return "Client/AddClient";
    }
    @PostMapping("/Add")
    public String AddClient( String nom,String Prenom, String adresse,String tele){

        ClientService.AddClient(nom,Prenom,adresse,tele);

        return "redirect:/Clients";
    }

}
