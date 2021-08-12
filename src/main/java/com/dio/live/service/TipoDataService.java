package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {


    @Autowired
    TipoDataRepository tipoDataRepository;

    public List<TipoData> findAllTipoData() {
        return tipoDataRepository.findAll();
    }

    public TipoData createTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public Optional<TipoData> getByIdTipoData(long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public TipoData updateTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public void deleteTipoData(long idTipoData) {
        tipoDataRepository.deleteById(idTipoData);
    }
}
