package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    @Autowired
    CalendarioRepository calendarioRepository;

    public Calendario createCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> getAll() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getByIdCalendario(long idCalendario) {
        return calendarioRepository.findById(idCalendario);
    }

    public Calendario updateCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public void deleteCalendario(long idCalendario) {
        calendarioRepository.deleteById(idCalendario);
    }
}
