package com.cristina_tiznado.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cristina_tiznado.canciones.modelos.Cancion;
import com.cristina_tiznado.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo){
        modelo.addAttribute("listaCanciones", this.servicio.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long Id, Model modelo){
        modelo.addAttribute("cancion", this.servicio.obtenerCancionPorId(Id));
        return "detalleCancion.jsp";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo){
        modelo.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones){
        if(validaciones.hasErrors()){
            return "agregarCancion.jsp";
        }
        this.servicio.agregarCancion(cancion);
        return "redirect:/canciones";

    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model modelo){
        modelo.addAttribute("cancion", this.servicio.obtenerCancionPorId(idCancion));
        return "editarCancion.jsp";
    }

    @PutMapping("/canciones/procesa/editar")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones){
        if(validaciones.hasErrors()){
            return "editarCancion.jsp";
        }
        this.servicio.actualizarCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion){
        this.servicio.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}
