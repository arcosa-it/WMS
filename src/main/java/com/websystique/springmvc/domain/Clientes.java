package com.websystique.springmvc.domain;

import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "clientes")
@NamedQueries({
        @NamedQuery(name = "Clientes.getAll",
            query = "select c from Clientes c")
})
public class Clientes implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cliente;
    private String nom_cliente;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }
}
