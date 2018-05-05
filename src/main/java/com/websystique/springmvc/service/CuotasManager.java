package com.websystique.springmvc.service;

import com.websystique.springmvc.domain.Cuotas;

import java.util.List;

public interface CuotasManager {

    public boolean insertcuota(Cuotas cuotas);

    public List<Cuotas> getCuotabyCliente(int id_cliente);

}
