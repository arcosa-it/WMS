package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Ingresos;
import com.websystique.springmvc.repository.IngresosDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Repository(value = "IngresosDao")
public class IngresosDaoImpl implements IngresosDao {

    private static final Logger logger = LoggerFactory
            .getLogger(IngresosDaoImpl.class);

    private EntityManager em = null;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = false)
    public boolean insertIngreso(Ingresos ingresos){
        boolean respuesta = false;
        try{
            em.persist(ingresos);
            respuesta=true;
        }catch (Exception e){
            logger.error("Error al intentar ingresar a la tabla de ingresos");
            respuesta = false;
        }

        return respuesta;
    }
    @Transactional(readOnly = false)
    public boolean insertarListaIngresos(List<Ingresos> ingresosList){
        boolean respuesta = false;
        try{
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            for(Iterator<Ingresos> iterator = ingresosList.iterator(); iterator.hasNext();){
                Ingresos ingresos = iterator.next();
                em.merge(ingresos);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            respuesta = true;
        }catch (Exception e){
            logger.error("Error al insertar una lista de entradas");
            e.printStackTrace();
            respuesta=false;
        }
        return  respuesta;
    }
}
