package com.websystique.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngresosController {

    private static final Logger logger = LoggerFactory
            .getLogger(AppController.class);

    @RequestMapping(value = "/subirDocumento", method = RequestMethod.GET)
    public String subirDocumento(Model model){
        logger.info("Vista para subir un documento de ingreso");
        return "subirDocumento";
    }

    @RequestMapping(value = "escaneo",method = RequestMethod.GET)
    public  String escaneo(Model model){
        logger.info("Vista para escanear con handhel");
        return "escaneo";
    }

}
