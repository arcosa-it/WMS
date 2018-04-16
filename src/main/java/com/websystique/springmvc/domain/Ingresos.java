package com.websystique.springmvc.domain;


import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "ingresos")
@NamedQueries({
    @NamedQuery(name = "Ingresos.getRegistro",
        query = "select i from Ingresos i where i.id_ingreso = :id_ingreso")
})
public class Ingresos implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_ingreso")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ingreso;
    private String lote;
    private int cantidad;
    private int id_cliente;
    private String marca;
    private float peso_bruto;
    private float peso_neto;
    private String codigo;
    private String sku;
    private String estatus;
    private String medidas;
    private String caducidad;
    private String fecha_produccion;
    private String hora;
    private int camara;
    private int id_documento;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(Integer id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(float peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public float getPeso_neto() {
        return peso_neto;
    }

    public void setPeso_neto(float peso_neto) {
        this.peso_neto = peso_neto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getFecha_produccion() {
        return fecha_produccion;
    }

    public void setFecha_produccion(String fecha_produccion) {
        this.fecha_produccion = fecha_produccion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCamara() {
        return camara;
    }

    public void setCamara(int camara) {
        this.camara = camara;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }
}
