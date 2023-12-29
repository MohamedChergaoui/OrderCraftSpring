package com.exemple.service.Client;

import com.exemple.entity.Client;
import com.exemple.entity.User;
import com.exemple.repository.InterfaceClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService implements IClient{
    @Autowired
    private InterfaceClientRepository interfaceClientRepository;


    @Override
    public List<Client> getCLient() {
        return interfaceClientRepository.findAll();
    }

    @Override
    public Client GitClientById(long id) {
        return interfaceClientRepository.findById(id);
    }

    @Override
    public Client ModClient(long id, String name, String Prenom, String addresse, String tele) {
        Client client= interfaceClientRepository.findById(id);

        client.setName(name);
        client.setPrenom(Prenom);
        client.setAdresse(addresse);
        client.setTele(tele);
        return interfaceClientRepository.save(client);
    }

    @Override
    public void DeleClient(long id) {
        interfaceClientRepository.deleteById(id);

    }

    @Override
    public Client AddClient(String name, String Prenom, String addresse, String tele) {
        Client client = new Client();
        client.setName(name);
        client.setPrenom(Prenom);
        client.setAdresse(addresse);
        client.setTele(tele);
        return interfaceClientRepository.save(client);

    }
}
