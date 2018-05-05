package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.domain.Inventario;
import com.websystique.springmvc.repository.InventariosDao;
import com.websystique.springmvc.service.InventariosManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventariosManagerImpl implements InventariosManager {

    @Autowired
    private InventariosDao inventariosDao;

    @Override
    public boolean insertInventario(Inventario inventario){
        return inventariosDao.insertInventario(inventario);
    }

    @Override
    public boolean insertListaInventarios(List<Inventario> inventarios){
        return inventariosDao.insertListaInventarios(inventarios);
    }

}
