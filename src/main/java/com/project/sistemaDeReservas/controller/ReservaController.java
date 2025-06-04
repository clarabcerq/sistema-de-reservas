package com.project.sistemaDeReservas.controller;

import com.project.sistemaDeReservas.model.Reserva;
import com.project.sistemaDeReservas.repository.ReservaRepository;
import com.project.sistemaDeReservas.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public Reserva salvarReserva(@RequestBody Reserva reserva) {
        return reservaService.salvar(reserva);
    }

    @GetMapping
    public List<Reserva> listarTodas() {
        return reservaService.listarTodas();
    }

    @GetMapping("/{id}")
    public List<Reserva> listarReservasPorUsuario(@PathVariable Long usuarioId) {
        return reservaService.buscarReservasPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Reserva atualizar(@RequestBody Reserva reserva, @PathVariable Long id) {
        return reservaService.atualizar(reserva, id);
    }

    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
    }
}
