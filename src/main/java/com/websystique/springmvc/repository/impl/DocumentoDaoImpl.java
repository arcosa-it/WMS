package com.websystique.springmvc.repository.impl;

import com.websystique.springmvc.domain.Documento;
import com.websystique.springmvc.repository.DocumentoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository(value = "DocumentoDao")
public class DocumentoDaoImpl implements DocumentoDao {

    private static final Logger logger = LoggerFactory.getLogger(DocumentoDaoImpl.class);

    private EntityManager em = null;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional(readOnly = false)
    public int insertDocumento(Documento documento){
        Documento documentofinal = new Documento();
        try{
            documentofinal = (Documento) em.createQuery("select d from Documento d where d.id_documento=(select max(d.id_documento) from Documento d)").getSingleResult();
            if(documentofinal!=null){
                documento.setId_documento(documentofinal.getId_documento() + 1);
            }else{
                documento.setId_documento(1);
            }
            em.persist(documento);
        }catch (Exception e){
            logger.error("Error al generar el documento");
            e.printStackTrace();
        }
        return documentofinal.getId_documento() + 1;
    }

}
