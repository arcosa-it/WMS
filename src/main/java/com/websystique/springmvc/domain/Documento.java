package com.websystique.springmvc.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documento")
@NamedQueries({
        @NamedQuery(name = "Documento.getAllByDocument",
                query = "select d from Documento d where d.id_documento= :documento")
})

public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_documento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_documento;
    private Integer id_cliente;
    private String fecha_ingreso;
    private String hora_ingreso;
    private Integer id_usuario;

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString(){
        return "Documento[id_documento="+id_documento+", id_cliente="+id_cliente+", fecha_ingreso="+fecha_ingreso
                +", hora_ingreso="+hora_ingreso+", id_usuario="+id_usuario+"]";
    }
}
