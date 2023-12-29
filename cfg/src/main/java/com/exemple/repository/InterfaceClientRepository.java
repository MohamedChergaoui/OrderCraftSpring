package com.exemple.repository;
import com.exemple.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InterfaceClientRepository")
public interface InterfaceClientRepository extends JpaRepository<Client,Long> {
    Client findById(long id);
}
