package com.exemple.service.Commande;

import com.exemple.entity.Commande;

import java.util.List;

public interface ICommande {
    public List<Commande> GetAllCommande();
    public Commande addCommande(int id_client);
    public void SetAmountOfCommande(int id_commande,double amount);
}
