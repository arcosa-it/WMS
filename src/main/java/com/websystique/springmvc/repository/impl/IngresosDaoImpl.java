package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Ingresos;
import com.websystique.springmvc.repository.IngresosDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "IngresosDao")
public class IngresosDaoImpl implements IngresosDao {

    private static final Logger logger = LoggerFactory
            .getLogger(IngresosDaoImpl.class);

    private EntityManager em = null;


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

}
