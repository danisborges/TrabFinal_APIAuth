package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Modulo;
import application.record.ModuloDTO;
import application.repository.ModuloRepository;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepo;
    
    public Iterable<ModuloDTO> getAll() {
        return moduloRepo.findAll().stream().map(ModuloDTO::new).toList();
    }

    public ModuloDTO insert(ModuloDTO modulo) {
        return new ModuloDTO(moduloRepo.save(new Modulo(modulo)));
    }
}

/// CONTINUAÇÃO - https://github.com/marcoweb/ex-api-20250310/blob/main/src/main/java/application/service/GeneroService.java