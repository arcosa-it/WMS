package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Ingresos;
import com.websystique.springmvc.repository.IngresosDao;
import com.websystique.springmvc.service.IngresosManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngresosManagerImpl implements IngresosManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IngresosDao ingresosDao;

    @Override
    public boolean insertIngreso(Ingresos ingresos){
        return ingresosDao.insertIngreso(ingresos);
    }

    @Override
    public boolean insertarListaIngresos(List<Ingresos> ingresosList){
        return ingresosDao.insertarListaIngresos(ingresosList);
    }

}
