package com.websystique.springmvc.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "camara")
@NamedQueries({
        @NamedQuery(name = "Camara.getAll",
                query = "select c from Camara c")
})
public class Camara implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_camara")
    private Integer id_camara;
    private String camara;
    private String clave;

    public Integer getId_camara() {
        return id_camara;
    }

    public void setId_camara(Integer id_camara) {
        this.id_camara = id_camara;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
