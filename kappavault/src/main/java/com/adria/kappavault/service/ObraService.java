package com.adria.kappavault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adria.kappavault.model.Obra;
import com.adria.kappavault.repository.ObraRepository;

@Service
// DEFINE LA CLASE COMO SERVICIO DE SPRING
public class ObraService {

    // REPOSITORIO DE OBRAS
    private final ObraRepository repo;

    // INYECCIÓN DEL REPOSITORIO
    public ObraService(ObraRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODAS LAS OBRAS
    public List<Obra> obtenerTodas() {
        return repo.findAll();
    }

    // BUSCAR OBRA POR ID
    public Obra obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    // GUARDAR OBRA EN LA BASE DE DATOS
    public Obra guardar(Obra obra) {
        return repo.save(obra);
    }

}
