package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Camara;
import com.websystique.springmvc.repository.CamaraDao;
import com.websystique.springmvc.service.CamaraManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CamaraManagerImpl implements CamaraManager {

    @Autowired
    private CamaraDao camaraDao;

    @Override
    public boolean insertCamara(Camara camara){
        return camaraDao.insertCamara(camara);
    }

    @Override
    public List<Camara> getAllCamara(){
        return camaraDao.getAllCamara();
    }
}
