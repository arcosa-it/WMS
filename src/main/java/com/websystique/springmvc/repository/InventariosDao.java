package com.websystique.springmvc.repository;

import com.websystique.springmvc.domain.Inventario;

import java.util.List;

public interface InventariosDao {

    public boolean insertInventario(Inventario inventario);
    public boolean insertListaInventarios(List<Inventario> inventarios);

}
