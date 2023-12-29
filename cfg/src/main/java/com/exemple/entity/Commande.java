package com.exemple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatuCommande() {
        return statuCommande;
    }

    public void setStatuCommande(String statuCommande) {
        this.statuCommande = statuCommande;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<Product> getProduits() {
        return produits;
    }

    public void setProduits(Set<Product> produits) {
        this.produits = produits;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date orderDate;

    @Column(name = "statuCommande", length = 222, nullable = false, columnDefinition = "varchar(222) default 'attente'")
    private String statuCommande;

    @Column(name = "total_amount", nullable = false, columnDefinition = "DECIMAL(10, 2) default 0")
    private BigDecimal totalAmount;

    @ManyToMany
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Product> produits = new HashSet<>();

    // Other fields, getters, and setters
}
