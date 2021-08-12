package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BancoHorasService {

    @Autowired
    BancoHorasRepository bancoHorasRepository;


    public BancoHoras createBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAllBancoHoras() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> finfByIdBancoHoras(long idBancoHoras) {
        return bancoHorasRepository.findById(idBancoHoras);
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(long idBancoHoras) {
        bancoHorasRepository.deleteById(idBancoHoras);
    }
}
