package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Curso;
import application.model.Modulo;
import application.record.ModuloDTO;
import application.repository.ModuloRepository;
import application.repository.CursoRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepo;

    @Autowired
    private CursoRepository cursoRepo;  // Para validar o curso

    public ModuloDTO create(ModuloDTO moduloDTO) {
        Curso curso = cursoRepo.findById(moduloDTO.cursoId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        Modulo modulo = new Modulo(moduloDTO);
        modulo.setCurso(curso);  // Associa o módulo ao curso
        modulo = moduloRepo.save(modulo);
        return new ModuloDTO(modulo);
    }

    public Set<ModuloDTO> getByCursoId(Long cursoId) {
        return moduloRepo.findByCursoId(cursoId).stream()
            .map(ModuloDTO::new)
            .collect(Collectors.toSet());
    }

    public void delete(Long id) {
        if (!moduloRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Módulo não encontrado");
        }
        moduloRepo.deleteById(id);
    }
}