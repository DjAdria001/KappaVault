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
import com.adria.kappavault.repository.ObraRepository;
import com.adria.kappavault.repository.ReviewRepository;

@Controller
@RequestMapping("/obras")
public class ObraController {

    private final ObraRepository obraRepository;
    private final ReviewRepository reviewRepository;

    public ObraController(
            ObraRepository obraRepository,
            ReviewRepository reviewRepository
    ) {
        this.obraRepository = obraRepository;
        this.reviewRepository = reviewRepository;
    }

    // LISTADO DE OBRAS
    @GetMapping
    public String listarObras(Model model) {

        model.addAttribute(
                "obras",
                obraRepository.findAll()
        );

        return "obras/lista";
    }

    // DETALLE DE OBRA
    @GetMapping("/{id}")
    public String detalle(
            @PathVariable Long id,
            Model model
    ) {
        Obra obra = obraRepository
                .findById(id)
                .orElseThrow();

        model.addAttribute("obra", obra);

        model.addAttribute(
                "review",
                new Review()
        );

        return "obras/detalle";
    }

    // CREAR REVIEW
    @PostMapping("/{id}/review")
    public String crearReview(
            @PathVariable Long id,
            @ModelAttribute Review review
    ) {
        Obra obra = obraRepository
                .findById(id)
                .orElseThrow();

        // FORZAR NUEVA REVIEW
        review.setId(null);

        // RELACIÓN CON LA OBRA
        review.setObra(obra);

        // GUARDAR
        reviewRepository.save(review);

        return "redirect:/obras/" + id;
    }
}
