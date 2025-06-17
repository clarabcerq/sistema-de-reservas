package com.project.sistemaDeReservas.service;

import com.project.sistemaDeReservas.dto.ReservaDTO;
import com.project.sistemaDeReservas.model.Local;
import com.project.sistemaDeReservas.model.Reserva;
import com.project.sistemaDeReservas.model.Usuario;
import com.project.sistemaDeReservas.repository.LocalRepository;
import com.project.sistemaDeReservas.repository.ReservaRepository;
import com.project.sistemaDeReservas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ReservaDTO salvar(Reserva reserva) {
        Long usuarioId = reserva.getUsuario().getId();
        Long localId = reserva.getLocal().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Local local = localRepository.findById(localId)
                        .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        reserva.setUsuario(usuario);
        reserva.setLocal(local);

        Reserva reservaSalva = reservaRepository.save(reserva);

        return toDTO(reservaSalva);
    }

    public List<ReservaDTO> listarTodas() {
        List<Reserva> reservas = reservaRepository.findAll();
        List<ReservaDTO> reservasDTO = new ArrayList<>();

        for (Reserva reserva : reservas) {
            reservasDTO.add(toDTO(reserva));
        }

        return reservasDTO;
    }

    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return reservaRepository.findByUsuarioId(usuarioId);
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

    public ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();

        dto.setId(reserva.getId());
        dto.setInicio(reserva.getInicio());
        dto.setEncerramento(reserva.getEncerramento());

        if (reserva.getUsuario() != null) {
            dto.setUsuarioNome(reserva.getUsuario().getNome());
        }

        if(reserva.getLocal() != null) {
            dto.setLocalNome(reserva.getLocal().getNome());
        }

        return dto;
    }
}
