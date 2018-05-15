package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Documento;
import com.websystique.springmvc.repository.DocumentoDao;
import com.websystique.springmvc.service.DocumentoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentoManagerImpl implements DocumentoManager {

    @Autowired
    private DocumentoDao documentoDao;

    @Override
    public void insertDocumento(Documento documento){
         documentoDao.insertDocumento(documento);
    }

    @Override
    public int getDocumento(){ return documentoDao.getDocumento();}

}
