package com.websystique.springmvc.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auditoria")
@NamedQueries({
        @NamedQuery(name = "Auditoria.getAll",
                query = "select c from Auditoria c")
})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_auditoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_auditoria;
    private Integer id_usuario;
    private String fecha_modificacion;
    private String fecha_insercion;
    private String descripcion_movimientos;

    public Integer getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(Integer id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getFecha_insercion() {
        return fecha_insercion;
    }

    public void setFecha_insercion(String fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    public String getDescripcion_movimientos() {
        return descripcion_movimientos;
    }

    public void setDescripcion_movimientos(String descripcion_movimientos) {
        this.descripcion_movimientos = descripcion_movimientos;
    }
}
