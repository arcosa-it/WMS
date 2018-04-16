package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Clientes;
import com.websystique.springmvc.repository.ClientesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "ClientesDao")
@Transactional(readOnly = false)
public class ClientesDaoImpl implements ClientesDao{

    private static final Logger logger = LoggerFactory
            .getLogger(ClientesDaoImpl.class);


    @PersistenceContext(unitName = "MySQL")
    private EntityManager em;


    @Override
    public List<Clientes> getAll(){
        try {
            Query query = em.createNamedQuery("Clientes.getAll");
            return query.getResultList();
        }catch (Exception e){
            logger.error("No se pudieron obtener todos lo clientes "+e.getCause()+" "+e.getMessage());
            e.printStackTrace();
            return new ArrayList<Clientes>();
        }
    }

}
