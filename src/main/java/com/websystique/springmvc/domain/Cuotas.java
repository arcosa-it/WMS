package com.websystique.springmvc.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuotas")
@NamedQueries({
        @NamedQuery(name = "Cuotas.getCuotasbyCliente",
                query = "select c from Cuotas c where c.id_cliente = :id_cliente")
})
public class Cuotas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cuota")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cuota;
    private Integer id_cliente;
    private String clave_producto;
    private String producto;
    private int periodo;

    public Integer getId_cuota() {
        return id_cuota;
    }

    public void setId_cuota(Integer id_cuota) {
        this.id_cuota = id_cuota;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
