package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Documento;
import com.websystique.springmvc.repository.DocumentoDao;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository(value = "DocumentoDao")
public class DocumentoDaoImpl implements DocumentoDao {

    private static final Logger logger = LoggerFactory.getLogger(DocumentoDaoImpl.class);

    @PersistenceContext(unitName = "MySQL")
    private EntityManager em;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = false)
    public void insertDocumento(Documento documento){
        try{
            em.persist(documento);
        }catch (Exception e){
            logger.error("Error al generar el documento");
            e.printStackTrace();
        }
    }

    @Override
    public  int getDocumento(){
        try{
            Query query = em.createNamedQuery("Documento.getDocumento");
            return (int) query.getResultList().get(0);
        }catch (QueryException e){
            logger.error("Error al traer el ultimo documento");
            e.printStackTrace();
            return 0;
        }
    }

}
