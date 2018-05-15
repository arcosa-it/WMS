package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Auditoria;
import com.websystique.springmvc.repository.AuditoriaDao;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("AuditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDao {

    private static final Logger logger = LoggerFactory.getLogger(AuditoriaDaoImpl.class);

    @PersistenceContext(unitName = "MySQL")
    private EntityManager em;

    @Transactional(readOnly = false)
    public boolean insertauditoria(Auditoria auditoria){
        boolean respuesta=false;
        try{
            em.persist(auditoria);
            respuesta=true;
        }catch (Exception e){
            logger.error("Error al insertar campo en la tabla de auditoria");
            e.printStackTrace();
            respuesta=false;
        }
        return respuesta;
    }

    @Override
    public List<Auditoria> getAllAuditoria(){
        try {
            Query query = em.createNamedQuery("Auditoria.getAll");
            return query.getResultList();
        }catch (QueryException q){
            logger.error("error al traer los registros de la tabla de auditoria");
            q.printStackTrace();
            return new ArrayList<Auditoria>();
        }
    }
}
