package com.websystique.springmvc.service;

import com.websystique.springmvc.domain.Auditoria;

import java.util.List;

public interface AuditoriaManager {

    public boolean insertauditoria(Auditoria auditoria);

    public List<Auditoria> getAllAuditoria();

}
