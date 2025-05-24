package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import application.record.CursoDTO;
import application.service.CursoService;

import java.util.Set;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public Set<CursoDTO> listarTodos() {
        return cursoService.getAll();
    }

    @GetMapping("/{id}")
    public CursoDTO buscarPorId(@PathVariable Long id) {
        return cursoService.getById(id);
    }

    @PostMapping
    public CursoDTO criar(@RequestBody CursoDTO cursoDTO) {
        return cursoService.create(cursoDTO);
    }

    @PutMapping("/{id}")
    public CursoDTO atualizar(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        return cursoService.update(id, cursoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cursoService.delete(id);
    }
    @PostMapping("/{cursoId}/matricular/{alunoId}")
    public CursoDTO matricularAluno(@PathVariable Long cursoId, @PathVariable Long alunoId) {
    return cursoService.matricularAluno(cursoId, alunoId);
}
}