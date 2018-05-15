package com.websystique.springmvc.repository;

import com.websystique.springmvc.domain.Ingresos;

import java.util.List;

public interface IngresosDao {

    public boolean insertIngreso(Ingresos ingresos);
    public boolean insertarListaIngresos(List<Ingresos> ingresosList);
    public int siguienteRenglon(int id_documento);
}
