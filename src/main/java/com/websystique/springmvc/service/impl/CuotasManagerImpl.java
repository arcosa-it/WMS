package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Cuotas;
import com.websystique.springmvc.repository.CuotasDao;
import com.websystique.springmvc.service.CuotasManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CuotasManagerImpl implements CuotasManager {

    @Autowired
    private CuotasDao cuotasDao;

    @Override
    public boolean insertcuota(Cuotas cuotas){
       return cuotasDao.insertcuota(cuotas);
    }

    @Override
    public List<Cuotas> getCuotabyCliente(int id_cliente){
        return cuotasDao.getCuotabyCliente(id_cliente);
    }

}
