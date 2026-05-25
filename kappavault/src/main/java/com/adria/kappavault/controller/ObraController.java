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

    private final ObraService obraService;
    private final ReviewService reviewService;

    // Inyectamos los servicios en lugar de los repositorios directamente
    public ObraController(ObraService obraService, ReviewService reviewService) {
        this.obraService = obraService;
        this.reviewService = reviewService;
    }

    // LISTADO DE OBRAS + FORMULARIO DE CREACIÓN
    @GetMapping
    public String listarObras(Model model) {
        model.addAttribute("obras", obraService.obtenerTodas());

        // Enviamos un objeto vacío para que el formulario de 'lista.html' pueda vincular los campos
        model.addAttribute("nuevaObra", new Obra());

        return "obras/lista";
    }

    // GUARDAR NUEVO ANIME / OBRA
    @PostMapping("/nuevo")
    public String crearObra(@ModelAttribute("nuevaObra") Obra obra) {
        obraService.guardar(obra);
        return "redirect:/obras"; // Redirige a la lista para ver el nuevo anime creado
    }

    // DETALLE DE OBRA
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Obra obra = obraService.obtenerPorId(id);
        if (obra == null) {
            return "redirect:/obras"; // Evita errores si el ID no existe
        }

        model.addAttribute("obra", obra);
        model.addAttribute("review", new Review());

        return "obras/detalle";
    }

    // CREAR REVIEW
    @PostMapping("/{id}/review")
    public String crearReview(@PathVariable Long id, @ModelAttribute Review review) {
        Obra obra = obraService.obtenerPorId(id);
        if (obra == null) {
            return "redirect:/obras";
        }

        review.setId(null); // Fuerza la creación de un nuevo registro
        review.setObra(obra); // Vincula la reseña con este anime

        reviewService.guardar(review);

        return "redirect:/obras/" + id;
    }

    // ELIMINAR OBRAS
    @PostMapping("/eliminar/{id}")
    public String eliminarObra(@PathVariable Long id) {
        obraService.eliminar(id);
        return "redirect:/obras";
    }

    // ELIMINAR REVIEW
    @PostMapping("/{obraId}/review/eliminar/{reviewId}")
    public String eliminarReview(@PathVariable Long obraId, @PathVariable Long reviewId) {
        reviewService.eliminar(reviewId);
        return "redirect:/obras/" + obraId; // Te devuelve a la misma ficha de detalle en la que estabas
    }
}
