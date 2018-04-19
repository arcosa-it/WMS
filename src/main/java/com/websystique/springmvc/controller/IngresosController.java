package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.ClientesManager;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/escaneo",method = RequestMethod.GET)
    public  String escaneo(Model model){
        logger.info("Vista para escanear con handhel");
        return "escaneo";
    }

    @RequestMapping(value = "capturaManual")
    public String capturaManual(Model model){
        logger.info("Vista para capturar manualmente un documento");
        return "capturaManual";
    }

    @RequestMapping(value = "leerExcel", method = RequestMethod.POST)
    public String leerExcel(Model model, HttpServletRequest request, HttpServletResponse response){
        logger.info("Metodo para subir el archivo para ingresarlo a la BD");
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = new ArrayList<FileItem>();
        /*try{
            fileItems = fileUpload.parseRequest(request);
        }catch (FileUploadException e){
            e.printStackTrace();
        }*/
        return "leerExcel";
    }

}
