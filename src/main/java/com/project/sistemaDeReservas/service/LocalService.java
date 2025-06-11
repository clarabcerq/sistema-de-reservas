package com.project.sistemaDeReservas.service;

import com.project.sistemaDeReservas.dto.LocalDTO;
import com.project.sistemaDeReservas.model.Local;
import com.project.sistemaDeReservas.repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    private LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public Local salvar(Local local) {
        return localRepository.save(local);
    }

    public List<Local> buscarTodos() {
        return localRepository.findAll();
    }

    public Local buscarPorId(Long id) {
        return localRepository.findById(id).orElse(null);
    }

    public Local atualizar(Local localAtualizado, Long id) {
        return localRepository.findById(id)
                .map(local -> {
                    local.setNome(localAtualizado.getNome());
                    local.setTipo(localAtualizado.getTipo());
                    local.setEndereco(localAtualizado.getEndereco());
                    return localRepository.save(local);
                })
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));
    }

    public void deletar(Long id) {
        localRepository.deleteById(id);
    }

    public LocalDTO toDTO(Local local) {
        return new LocalDTO(
                local.getNome(),
                local.getTipo(),
                local.getEndereco()
        );
    }
}
