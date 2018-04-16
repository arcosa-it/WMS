package com.websystique.springmvc.service;

import com.websystique.springmvc.domain.Clientes;

import java.io.Serializable;
import java.util.List;

public interface ClientesManager extends Serializable{

    public List<Clientes> getAll();

}
