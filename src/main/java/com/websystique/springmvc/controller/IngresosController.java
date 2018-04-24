package com.websystique.springmvc.controller;

import com.websystique.springmvc.domain.Ingresos;
import com.websystique.springmvc.service.ClientesManager;
import com.websystique.springmvc.service.IngresosManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(types = IngresosController.class)
public class IngresosController {

    private static final Logger logger = LoggerFactory
            .getLogger(AppController.class);

    @Autowired
    private ClientesManager clientesManager;
    @Autowired
    private IngresosManager ingresosManager;

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

    @RequestMapping(value = "admin_leerExcel",method = RequestMethod.POST)
    public String leerExcel(Model model, /*HttpServletRequest request,*/ @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "idcliente")int idcliente/*, HttpServletResponse response*/){
        logger.info("Metodo para subir el archivo para ingresarlo a la BD");
        /*ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = new ArrayList<FileItem>();*/
        List<Ingresos> ingresosList= new ArrayList<Ingresos>();
        /*try{
            fileItems = fileUpload.parseRequest(request);
        }catch (FileUploadException e){
            e.printStackTrace();
        }*/
        final Date date = new Date();
        final SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
        final String fecha = formatFecha.format(date);
        final String hora = formatHora.format(date);
        Workbook workbook = null;
        InputStream ExcelFileToRead=null;
        Ingresos ingresos = new Ingresos();
        boolean respuestaIngresos= false;
        try{
            //ExcelFileToRead = fileItems.get(0).getInputStream();
            ExcelFileToRead = file.getInputStream();
            workbook = Workbook.getWorkbook(ExcelFileToRead);
            Sheet sheet = workbook.getSheet(0);
            for (int i=0; i<sheet.getRows(); i++){
                ingresos.setCamara(1);
                ingresos.setId_cliente(idcliente);
                ingresos.setCodigo(sheet.getCell(0,i).getContents());
                ingresos.setPeso_bruto(Float.parseFloat(sheet.getCell(1,i).getContents()));
                ingresos.setSku(sheet.getCell(2,i).getContents());
                ingresos.setLote(sheet.getCell(3,i).getContents());
                ingresos.setPeso_neto(Float.parseFloat(sheet.getCell(4,i).getContents()));
                ingresos.setDescripcion(sheet.getCell(5,i).getContents());
                ingresos.setCantidad(Integer.parseInt(sheet.getCell(7,i).getContents()));
                ingresos.setFecha_produccion(fecha);
                ingresos.setHora(hora);
                ingresosList.add(ingresos);
                ingresos = new Ingresos();
            }

            respuestaIngresos = this.ingresosManager.insertarListaIngresos(ingresosList);


        }catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }
        }
        return "leerExcel";
    }

}
