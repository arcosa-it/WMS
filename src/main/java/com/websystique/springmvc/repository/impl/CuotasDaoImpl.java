package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Cuotas;
import com.websystique.springmvc.repository.CuotasDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "CuotasDao")
public class CuotasDaoImpl implements CuotasDao {

    private static final Logger logger = LoggerFactory.getLogger(CuotasDaoImpl.class);

    @PersistenceContext(unitName = "MySQL")
    private EntityManager em;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = false)
    public boolean insertcuota(Cuotas cuotas){
        boolean respuesta=false;
        try{
            em.persist(cuotas);
            respuesta=true;
        }catch (Exception e){
            logger.error("Error al insertar cuota");
            e.printStackTrace();
            respuesta=false;
        }
        return respuesta;
    }

    @Override
    public List<Cuotas> getCuotabyCliente(int id_cliente){
        try{
            Query query = em.createNamedQuery("Cuotas.getCuotasbyCliente");
            query.setParameter("id_cliente",id_cliente);
            return query.getResultList();
        }catch (Exception e){
            logger.error("Error al obteener las cuotas por cliente");
            e.printStackTrace();
            return new ArrayList<Cuotas>();
        }
    }

}
