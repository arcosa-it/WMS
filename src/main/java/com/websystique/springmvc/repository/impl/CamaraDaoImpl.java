package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Camara;
import com.websystique.springmvc.repository.CamaraDao;
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

@Repository("CamaraDao")
public class CamaraDaoImpl implements CamaraDao {

    private static final Logger logger = LoggerFactory.getLogger(CamaraDaoImpl.class);

    @PersistenceContext(unitName = "MySQL")
    private EntityManager em;

    @Transactional
    public boolean insertCamara(Camara camara){
        boolean respuesta = false;
        try{
            em.persist(camara);
            respuesta = true;
        }catch (Exception e){
            logger.error("Error al ingresar una camara");
            e.printStackTrace();
            respuesta=false;
        }

        return respuesta;
    }

    @Override
    public List<Camara> getAllCamara(){
        try {
            Query query = em.createNamedQuery("Camara.getAll");
            return query.getResultList();
        }catch (QueryException e){
            logger.error("Error al traer el catalogo de camara");
            e.printStackTrace();
            return new ArrayList<Camara>();
        }
    }

}
