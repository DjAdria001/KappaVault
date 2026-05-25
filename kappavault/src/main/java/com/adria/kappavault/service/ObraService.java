
package com.adria.kappavault.service;

import com.adria.kappavault.model.Obra;
import com.adria.kappavault.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
