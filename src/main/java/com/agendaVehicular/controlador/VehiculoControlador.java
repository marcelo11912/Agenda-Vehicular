package com.agendaVehicular.controlador;

import com.agendaVehicular.modelo.entity.Vehiculo;
import com.agendaVehicular.modelo.service.IVehiculoService;
import java.io.Serializable;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehiculoControlador implements Serializable {

    @Autowired
    IVehiculoService vehiculoService;

    @RequestMapping(value = {"/", "/principal"}, method = RequestMethod.GET)
    public String principal(Model modelo) {
        return "principal";

    }

    @RequestMapping(value = "/verVehiculo/{idvehiculo}")
    public String lista(@PathVariable(value = "idvehiculo") Long idvehiculo, Model modelo, RedirectAttributes flash) {
        Vehiculo vehiculo = null;
        if (idvehiculo > 0) {
            vehiculo = vehiculoService.findOne(idvehiculo);

        } else {

            return "redirect:/vehiculo";
        }
        modelo.addAttribute("vehiculo", vehiculo);
        modelo.addAttribute("titulo", "Editar Vehiculo");
        modelo.addAttribute("button", "Editar Vehiculo");
        return "verVehiculo";

    }

  

    @RequestMapping(value = {"/vehiculo"}, method = RequestMethod.GET)
    public String vehiculo(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
        Pageable pageRequest = PageRequest.of(page, 20);
        Page<Vehiculo> vehiculos = vehiculoService.findAll(pageRequest);
        modelo.addAttribute("vehiculos", vehiculos);

        return "vehiculo";

    }

    @RequestMapping(value = {"/formVehiculo"}, method = RequestMethod.GET)
    public String formVehiculo(Model modelo) {
        Vehiculo vehiculo = new Vehiculo();
        modelo.addAttribute("titulo", "Agregar Vehiculo");
        modelo.addAttribute("vehiculo", vehiculo);
        modelo.addAttribute("button", "Registrar Vehiculo");
        return "formVehiculo";
    }

    @RequestMapping(value = "/formVehiculo", method = RequestMethod.POST)
    public String guardar(@Valid Vehiculo vehiculo, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            modelo.addAttribute("titulo", "Agregar Vehiculo");
            modelo.addAttribute("button", "Registrar Vehiculo");
            return "formVehiculo";
        }

        String mensajeFlash = (vehiculo.getIdvehiculo() != null) ? "Vehiculo modificado con éxito" : "Vehiculo creado con éxito";
        vehiculoService.save(vehiculo);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:vehiculo";

    }
    

    @RequestMapping(value = "/formKM", method = RequestMethod.POST)
    public String guardarKM(@Valid Vehiculo vehiculo, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            return "formKM";
        }

       
        vehiculoService.save(vehiculo);

        return "redirect:vehiculo";

    }
    
    
    
    @RequestMapping(value = "/formVehiculo/{idvehiculo}")
    public String editar(@PathVariable(value = "idvehiculo") Long idvehiculo, Model modelo, RedirectAttributes flash) {
        Vehiculo vehiculo = null;
        if (idvehiculo > 0) {
            vehiculo = vehiculoService.findOne(idvehiculo);

        } else {

            return "redirect:/vehiculo";
        }
        modelo.addAttribute("vehiculo", vehiculo);
        modelo.addAttribute("titulo", "Editar Vehiculo");
        modelo.addAttribute("button", "Editar Vehiculo");
        return "formVehiculo";

    }
    
     @RequestMapping(value = "/formKM/{idvehiculo}")
    public String KM(@PathVariable(value = "idvehiculo") Long idvehiculo, Model modelo, RedirectAttributes flash) {
        Vehiculo vehiculo = null;
        if (idvehiculo > 0) {
            vehiculo = vehiculoService.findOne(idvehiculo);

        } else {

            return "redirect:/vehiculo";
        }
        modelo.addAttribute("vehiculo", vehiculo);
        modelo.addAttribute("button", "Registrar");
        return "formKM";

    }
    



    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            vehiculoService.delete(id);
        }
        flash.addFlashAttribute("success", "Cliente eliminado con éxito");
        return "redirect:/vehiculo";
    }

}
































