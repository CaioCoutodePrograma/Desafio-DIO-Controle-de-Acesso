package com.dio.live.service;


import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia createOcorrencia(Ocorrencia ocorrencia) {
        return  ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> findAllOcorrencia() {
        return  ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getByIdOcorrencia(long idOcorrencia) {
        return ocorrenciaRepository.findById(idOcorrencia);
    }

    public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void deleteOcorrencia(long idOcorrencia) {
        ocorrenciaRepository.deleteById(idOcorrencia);
    }
}
