package com.websystique.springmvc.repository;

import com.websystique.springmvc.domain.Camara;

import java.util.List;

public interface CamaraDao {

    public boolean insertCamara(Camara camara);

    public List<Camara> getAllCamara();

}
