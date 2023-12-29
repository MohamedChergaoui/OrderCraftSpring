package com.exemple.service.Commande;

import com.exemple.entity.Commande;
import com.exemple.repository.InterfaceCommandeRespotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeService implements ICommande {
    @Autowired
    private InterfaceCommandeRespotry ServiceRepo;
    @Override
    public List<Commande> GetAllCommande() {
        return ServiceRepo.findAll();
    }

    @Override
    public Commande addCommande(int id_client) {
        return ServiceRepo.updateByClient(id_client);

    }

    @Override
    public void SetAmountOfCommande(int id_commande, double amount) {

    }
}
