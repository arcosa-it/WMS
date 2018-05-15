package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Auditoria;
import com.websystique.springmvc.repository.AuditoriaDao;
import com.websystique.springmvc.service.AuditoriaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditoriaManagerImpl implements AuditoriaManager {

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Override
    public boolean insertauditoria(Auditoria auditoria){
        return auditoriaDao.insertauditoria(auditoria);
    }

    @Override
    public List<Auditoria> getAllAuditoria(){
        return auditoriaDao.getAllAuditoria();
    }

}
