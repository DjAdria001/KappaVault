package com.adria.kappavault.repository;

// IMPORTA LA ENTIDAD OBRA
import org.springframework.data.jpa.repository.JpaRepository;

import com.adria.kappavault.model.Obra;

// REPOSITORIO DE LA ENTIDAD OBRA
public interface ObraRepository extends JpaRepository<Obra, Long> {

    // HEREDA MÉTODOS CRUD AUTOMÁTICOS:
    // save()
    // findAll()
    // findById()
    // deleteById()
}
