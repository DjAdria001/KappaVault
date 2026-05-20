package com.adria.kappavault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adria.kappavault.model.Obra;
import com.adria.kappavault.repository.ObraRepository;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> obtenerTodas() {
        return obraRepository.findAll();
    }

    public Obra guardar(Obra obra) {
        return obraRepository.save(obra);
    }

    public void eliminar(Long id) {
        obraRepository.deleteById(id);
    }
}
