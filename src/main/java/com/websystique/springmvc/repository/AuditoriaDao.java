package com.websystique.springmvc.repository;

import com.websystique.springmvc.domain.Auditoria;

import java.util.List;

public interface AuditoriaDao {

    public boolean insertauditoria(Auditoria auditoria);

    public List<Auditoria> getAllAuditoria();

}
