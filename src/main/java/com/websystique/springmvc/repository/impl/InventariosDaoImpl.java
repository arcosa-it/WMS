package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Inventario;
import com.websystique.springmvc.repository.InventariosDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;

@Repository(value = "InventariosDao")
public class InventariosDaoImpl implements InventariosDao {

    private static final Logger logger = LoggerFactory.getLogger(InventariosDaoImpl.class);

    private EntityManager em = null;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = false)
    public  boolean insertInventario(Inventario inventario){
        boolean respuesta = false;
        try{
            em.persist(inventario);
            respuesta=true;
        }catch (Exception e){
            logger.error("Error al insertar al inventario");
            e.printStackTrace();
            respuesta=false;
        }

        return respuesta;
    }

    @Transactional(readOnly = false)
    public boolean insertListaInventarios(List<Inventario> inventarios){
        boolean respuesta=false;
        try{
            em=entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            for (Iterator<Inventario> iterator=inventarios.iterator(); iterator.hasNext();){
                Inventario inventario = iterator.next();
                em.merge(inventario);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            respuesta=true;
        }catch (Exception e){
            logger.error("Error al insertar una lista de inventarios");
            e.printStackTrace();
            respuesta=false;
        }

        return respuesta;
    }

}
