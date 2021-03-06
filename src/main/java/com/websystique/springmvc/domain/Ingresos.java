package com.websystique.springmvc.domain;


import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "ingresos")
@NamedQueries({
    @NamedQuery(name = "Ingresos.getRegistro",
        query = "select i from Ingresos i where i.id_documento = :id_documento")
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
    private String descripcion;
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
    private String planta;
    private String fecha_ingreso;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
    private String campo5;
    private String campo6;
    private String campo7;
    private String campo8;
    private String campo9;
    private String campo10;
    private String temperatura;
    private String clave_producto;
    private int no_registro_documento;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getCampo9() {
        return campo9;
    }

    public void setCampo9(String campo9) {
        this.campo9 = campo9;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public int getNo_registro_documento() {
        return no_registro_documento;
    }

    public void setNo_registro_documento(int no_registro_documento) {
        this.no_registro_documento = no_registro_documento;
    }
}
