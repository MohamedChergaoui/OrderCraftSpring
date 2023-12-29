package com.exemple.service.Client;

import com.exemple.entity.Client;
import com.exemple.entity.User;

import java.util.List;

public interface IClient {
    public List<Client> getCLient();
    public Client GitClientById(long id);
    public Client ModClient(long id,String name,String Prenom ,String addresse,String tele);
    public void DeleClient(long id);
    public Client AddClient(String name,String Prenom ,String addresse,String tele);

}
