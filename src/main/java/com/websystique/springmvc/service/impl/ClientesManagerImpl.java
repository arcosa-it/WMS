package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Clientes;
import com.websystique.springmvc.repository.ClientesDao;
import com.websystique.springmvc.service.ClientesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesManagerImpl implements ClientesManager{

    @Autowired
    private ClientesDao clientesDao;

    @Override
    public List<Clientes> getAll(){ return  clientesDao.getAll();}

}
