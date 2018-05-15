package com.websystique.springmvc.controller;

import com.websystique.springmvc.domain.Auditoria;
import com.websystique.springmvc.domain.Documento;
import com.websystique.springmvc.domain.Ingresos;
import com.websystique.springmvc.domain.Inventario;
import com.websystique.springmvc.service.*;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    @Autowired
    private CuotasManager cuotasManager;
    @Autowired
    private CamaraManager camaraManager;
    @Autowired
    private DocumentoManager documentoManager;
    @Autowired
    UserService userService;
    @Autowired
    AuditoriaManager auditoriaManager;
    @Autowired
    private InventariosManager inventariosManager;

    @RequestMapping(value = "admin_ingresarDatos", method = RequestMethod.POST)
    public String ingresarDatos(Model model,@RequestParam(value = "id_documento")int id_documento,
                                @RequestParam(value = "lote")String lote,
                                @RequestParam(value = "cantidad")int cantidad,
                                @RequestParam(value = "marca")String marca,
                                @RequestParam(value = "peso_bruto")String peso_bruto,
                                @RequestParam(value = "peso_neto")String peso_neto,
                                @RequestParam(value = "sku")String sku,
                                @RequestParam(value = "estatus")String estatus,
                                @RequestParam(value = "medidas")String medidas,
                                @RequestParam(value = "caducidad")String caducidad,
                                @RequestParam(value = "fecha_produccion")String fecha_produccion,
                                @RequestParam(value = "descripcion_producto")String descripcion_producto,
                                @RequestParam(value = "id_cliente")int id_cliente,
                                @RequestParam(value = "cuota_cobro")String cuota_cobro,
                                @RequestParam(value = "camara")int camara,
                                @RequestParam(value = "temperatura")String temperatura,
                                @RequestParam(value = "hora_ingreso")String hora_ingreso,
                                @RequestParam(value = "fecha_ingreso")String fecha_ingreso){
        logger.info("Metodo para registrar los ingresos y devuelve una tabla con los ingresos registrados");
        Inventario inventario = new Inventario();
        Ingresos ingresos = new Ingresos();
        int renglon=this.ingresosManager.siguienteRenglon(id_documento)+1;

        ingresos.setId_documento(id_documento);
        ingresos.setLote(lote);
        ingresos.setCantidad(cantidad);
        ingresos.setMarca(marca);
        ingresos.setPeso_bruto(Float.parseFloat(peso_bruto));
        ingresos.setPeso_neto(Float.parseFloat(peso_neto));
        ingresos.setSku(sku);
        ingresos.setEstatus(estatus);
        ingresos.setMedidas(medidas);
        ingresos.setCaducidad(caducidad);
        ingresos.setFecha_produccion(fecha_produccion);
        ingresos.setDescripcion(descripcion_producto);
        ingresos.setId_cliente(id_cliente);
        ingresos.setClave_producto(cuota_cobro);
        ingresos.setCamara(camara);
        ingresos.setTemperatura(temperatura);
        ingresos.setHora(hora_ingreso);
        ingresos.setFecha_ingreso(fecha_ingreso);
        ingresos.setNo_registro_documento(renglon);

        inventario.setId_documento(id_documento);
        inventario.setLote(lote);
        inventario.setCantidad(cantidad);
        inventario.setMarca(marca);
        inventario.setPeso_bruto(Float.parseFloat(peso_bruto));
        inventario.setPeso_neto(Float.parseFloat(peso_neto));
        inventario.setSku(sku);
        inventario.setEstatus(estatus);
        inventario.setMedidas(medidas);
        inventario.setCaducidad(caducidad);
        inventario.setFecha_produccion(fecha_produccion);
        inventario.setDescripcion(descripcion_producto);
        inventario.setId_cliente(id_cliente);
        inventario.setClave_producto(cuota_cobro);
        inventario.setCamara(camara);
        inventario.setTemperatura(temperatura);
        inventario.setHora(hora_ingreso);
        inventario.setFecha_ingreso(fecha_ingreso);
        inventario.setNo_registro_documento(renglon);

        this.ingresosManager.insertIngreso(ingresos);
        this.inventariosManager.insertInventario(inventario);

        return "ingresarDatos";
    }

    @RequestMapping(value = "admin_crearDocumento", method = RequestMethod.POST)
    public String crearDocumento(Model model,@RequestParam(value = "id_cliente")int id_cliente,
                                 @RequestParam(value = "hora_ingreso")String hora_ingreso,
                                 @RequestParam(value = "fecha_ingreso")String fecha_ingreso){
        logger.info("Ajax para generar un id_documento");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Documento documento = new Documento();
        Auditoria auditoria = new Auditoria();
        documento.setId_cliente(id_cliente);
        documento.setFecha_ingreso(fecha_ingreso);
        documento.setHora_ingreso(hora_ingreso);
        documento.setId_usuario(this.userService.findBySSO(user.getUsername()).getId());
        this.documentoManager.insertDocumento(documento);
        int idDocumento = this.documentoManager.getDocumento();
        auditoria.setFecha_insercion(fecha_ingreso);
        auditoria.setFecha_modificacion(fecha_ingreso);
        auditoria.setId_usuario(this.userService.findBySSO(user.getUsername()).getId());
        auditoria.setDescripcion_movimientos("Se generó el documento numero "+idDocumento+", por el usuario "+user.getUsername());
        boolean respuesta = this.auditoriaManager.insertauditoria(auditoria);
        model.addAttribute("documento",idDocumento);
        return "crearDocumento";
    }

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
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaformatter = new SimpleDateFormat("hh:mm a");
        String fecha= simpleDateFormat.format(date);
        String hora = horaformatter.format(date);
        model.addAttribute("clientes",this.clientesManager.getAll());
        model.addAttribute("camaras", this.camaraManager.getAllCamara());
        model.addAttribute("now",fecha);
        model.addAttribute("time",hora);
        return "capturaManual";
    }

    @RequestMapping(value = "admin_recuperarcuotas", method = RequestMethod.POST)
    public String recuperarcuotas(Model model, @RequestParam(value = "id_cliente")int id_cliente){
        logger.info("ajax para recuprar cuotas");
        model.addAttribute("cuotas", this.cuotasManager.getCuotabyCliente(id_cliente));
        return "recuperarcoutas";
    }

    @RequestMapping(value = "admin_leerExcel",method = RequestMethod.POST)
    public  String leerExcel(Model model, /*HttpServletRequest request,*/ @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "idcliente")int idcliente/*, HttpServletResponse response*/){
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
