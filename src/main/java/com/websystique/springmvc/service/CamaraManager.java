package com.websystique.springmvc.service;

import com.websystique.springmvc.domain.Camara;

import java.util.List;

public interface CamaraManager {

    public boolean insertCamara(Camara camara);

    public List<Camara> getAllCamara();

}
