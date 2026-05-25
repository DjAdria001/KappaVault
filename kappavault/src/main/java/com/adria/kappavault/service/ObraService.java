package com.adria.kappavault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adria.kappavault.model.Obra;
import com.adria.kappavault.repository.ObraRepository;

@Service
public class ObraService {

    private final ObraRepository repo;

    public ObraService(ObraRepository repo) {
        this.repo = repo;
    }

    public List<Obra> obtenerTodas() {
        return repo.findAll();
    }

    public Obra obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Obra guardar(Obra obra) {
        return repo.save(obra);
    }

}
