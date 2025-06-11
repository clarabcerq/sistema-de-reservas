package com.project.sistemaDeReservas.controller;

import com.project.sistemaDeReservas.dto.UsuarioDTO;
import com.project.sistemaDeReservas.model.Usuario;
import com.project.sistemaDeReservas.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioDTO salvarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuarioService.toDTO(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.atualizar(usuario, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
