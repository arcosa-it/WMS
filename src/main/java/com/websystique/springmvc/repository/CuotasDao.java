package com.websystique.springmvc.repository;

import com.websystique.springmvc.domain.Cuotas;

import java.util.List;

public interface CuotasDao {

    public boolean insertcuota(Cuotas cuotas);

    public List<Cuotas> getCuotabyCliente(int id_cliente);

}
