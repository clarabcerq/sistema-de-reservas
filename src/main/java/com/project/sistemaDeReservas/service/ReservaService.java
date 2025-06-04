package com.project.sistemaDeReservas.service;

import com.project.sistemaDeReservas.model.Local;
import com.project.sistemaDeReservas.model.Reserva;
import com.project.sistemaDeReservas.model.Usuario;
import com.project.sistemaDeReservas.repository.LocalRepository;
import com.project.sistemaDeReservas.repository.ReservaRepository;
import com.project.sistemaDeReservas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    private LocalRepository localRepository;
    private UsuarioRepository usuarioRepository;

    public ReservaService(ReservaRepository reservaRepository, LocalRepository localRepository, UsuarioRepository usuarioRepository) {
        this.reservaRepository = reservaRepository;
        this.localRepository = localRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Reserva salvar(Reserva reserva) {
        Long usuarioId = reserva.getUsuario().getId();
        Long localId = reserva.getLocal().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Local local = localRepository.findById(localId)
                        .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        reserva.setUsuario(usuario);
        reserva.setLocal(local);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return reservaRepository.findByUsuario(usuario);
    }

    public Reserva atualizar(Reserva reservaAtualizada, Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setInicio(reservaAtualizada.getInicio());
        reserva.setEncerramento(reservaAtualizada.getEncerramento());
        reserva.setLocal(reservaAtualizada.getLocal());

        return reservaRepository.save(reserva);
    }

    public void cancelarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
