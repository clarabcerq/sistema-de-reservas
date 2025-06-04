package com.project.sistemaDeReservas.controller;

import com.project.sistemaDeReservas.model.Local;
import com.project.sistemaDeReservas.service.LocalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {

    private LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @PostMapping
    public Local salvarLocal(@RequestBody Local local) {
        return localService.salvar(local);
    }

    @GetMapping
    public List<Local> listarLocais() {
        return localService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Local burcarPorId(@PathVariable Long id) {
        return localService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Local atualizar(@RequestBody Local local, @PathVariable Long id) {
        return localService.atualizar(local, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        localService.deletar(id);
    }
}















