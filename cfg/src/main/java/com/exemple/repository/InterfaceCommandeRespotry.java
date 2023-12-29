package com.exemple.repository;

import com.exemple.entity.Client;
import com.exemple.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InterfaceCommandeRespotry")
public interface InterfaceCommandeRespotry extends JpaRepository<Commande,Long> {
    Commande findById(long id);
    Commande updateByClient(int idClient);
}
