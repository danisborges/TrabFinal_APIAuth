package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.ModuloDTO;
import application.service.ModuloService;

@RestController
@RequestMapping("/modulos")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public Iterable<ModuloDTO> getAll() {
        return moduloService.getAll();
    }

    @GetMapping("/{id}")
    public ModuloDTO findOne(@PathVariable long id) {
        return moduloService.getOne(id);
    }
    
    @PostMapping
    public ModuloDTO insert(@RequestBody ModuloDTO modulo) {
        return moduloService.insert(modulo);
    }

    @PutMapping("/{id}")
    public ModuloDTO update(@PathVariable long id, @RequestBody ModuloDTO modulo) {
        return moduloService.update(id, modulo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        moduloService.delete(id);
    }

}