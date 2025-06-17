package com.project.sistemaDeReservas.repository;

import com.project.sistemaDeReservas.model.Reserva;
import com.project.sistemaDeReservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long usuarioId);
}
