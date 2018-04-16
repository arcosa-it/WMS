package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.ClientesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngresosController {

    private static final Logger logger = LoggerFactory
            .getLogger(AppController.class);

    @Autowired
    private ClientesManager clientesManager;

    @RequestMapping(value = "/subirDocumento", method = RequestMethod.GET)
    public String subirDocumento(Model model){
        logger.info("Vista para subir un documento de ingreso");
        model.addAttribute("clientes",this.clientesManager.getAll());
        return "subirDocumento";
    }

    @RequestMapping(value = "escaneo",method = RequestMethod.GET)
    public  String escaneo(Model model){
        logger.info("Vista para escanear con handhel");
        return "escaneo";
    }

}
