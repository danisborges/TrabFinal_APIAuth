package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import application.record.ModuloDTO;
import application.service.ModuloService;

import java.util.Set;

@RestController
@RequestMapping("/modulos")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @PostMapping
    public ModuloDTO criar(@RequestBody ModuloDTO moduloDTO) {
        return moduloService.create(moduloDTO);
    }

    @GetMapping("/curso/{cursoId}")
    public Set<ModuloDTO> listarPorCurso(@PathVariable Long cursoId) {
        return moduloService.getByCursoId(cursoId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        moduloService.delete(id);
    }
}