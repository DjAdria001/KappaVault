package com.adria.kappavault.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adria.kappavault.model.Obra;
import com.adria.kappavault.model.Review;
import com.adria.kappavault.service.ObraService;
import com.adria.kappavault.service.ReviewService;

@Controller
@RequestMapping("/obras")
public class ObraController {

    // SERVICIO DE OBRAS
    private final ObraService obraService;

    // SERVICIO DE REVIEWS
    private final ReviewService reviewService;

    // INYECCIÓN DE SERVICIOS
    public ObraController(ObraService obraService, ReviewService reviewService) {
        this.obraService = obraService;
        this.reviewService = reviewService;
    }

    // MOSTRAR LISTA DE OBRAS
    @GetMapping
    public String listarObras(Model model) {

        // ENVÍA TODAS LAS OBRAS A LA VISTA
        model.addAttribute("obras", obraService.obtenerTodas());

        // CREA OBJETO VACÍO PARA EL FORMULARIO
        model.addAttribute("nuevaObra", new Obra());

        return "obras/lista";
    }

    // CREAR NUEVA OBRA
    @PostMapping("/nuevo")
    public String crearObra(@ModelAttribute("nuevaObra") Obra obra) {

        // GUARDA LA OBRA EN LA BASE DE DATOS
        obraService.guardar(obra);

        // REDIRECCIÓN AL LISTADO
        return "redirect:/obras";
    }

    // MOSTRAR DETALLE DE UNA OBRA
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {

        // BUSCA LA OBRA POR ID
        Obra obra = obraService.obtenerPorId(id);

        // SI NO EXISTE, VUELVE AL LISTADO
        if (obra == null) {
            return "redirect:/obras";
        }

        // ENVÍA LA OBRA A LA VISTA
        model.addAttribute("obra", obra);

        // CREA REVIEW VACÍA PARA EL FORMULARIO
        model.addAttribute("review", new Review());

        return "obras/detalle";
    }

    // CREAR REVIEW
    @PostMapping("/{id}/review")
    public String crearReview(@PathVariable Long id, @ModelAttribute Review review) {

        // OBTIENE LA OBRA
        Obra obra = obraService.obtenerPorId(id);

        // SI NO EXISTE, REDIRIGE
        if (obra == null) {
            return "redirect:/obras";
        }

        // FUERZA NUEVA REVIEW
        review.setId(null);

        // ASOCIA REVIEW A LA OBRA
        review.setObra(obra);

        // GUARDA REVIEW
        reviewService.guardar(review);

        return "redirect:/obras/" + id;
    }

    // ELIMINAR OBRA
    @PostMapping("/eliminar/{id}")
    public String eliminarObra(@PathVariable Long id) {

        // BORRA LA OBRA
        obraService.eliminar(id);

        return "redirect:/obras";
    }

    // ELIMINAR REVIEW
    @PostMapping("/{obraId}/review/eliminar/{reviewId}")
    public String eliminarReview(@PathVariable Long obraId, @PathVariable Long reviewId) {

        // BORRA LA REVIEW
        reviewService.eliminar(reviewId);

        // VUELVE AL DETALLE DE LA OBRA
        return "redirect:/obras/" + obraId;
    }
}
