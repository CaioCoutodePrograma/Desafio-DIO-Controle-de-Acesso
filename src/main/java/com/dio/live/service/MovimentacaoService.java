package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao createMovimentacao(Movimentacao movimentacao) {
       return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAllMovimentacao() {
        return  movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> getByIdMovimentacao(long idMovimentacao) {
        return movimentacaoRepository.findById(idMovimentacao);
    }

    public Movimentacao updateMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteMovimentacao(long idMovimentacao) {
        movimentacaoRepository.deleteById(idMovimentacao);
    }
}
