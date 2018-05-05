package com.websystique.springmvc.service;

import com.websystique.springmvc.domain.Inventario;

import java.util.List;

public interface InventariosManager {

    public boolean insertInventario(Inventario inventario);
    public boolean insertListaInventarios(List<Inventario> inventarios);

}
