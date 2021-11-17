package com.itkollegimsttest.SpringBootTest20211117.service;

import com.itkollegimsttest.SpringBootTest20211117.error.MesswerteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class MesswerteServiceImpl implements MesswerteService {

    @Autowired
    private MesswerteService messwerteRepository;

    @Override
    public Messwerte saveMesswerte(Messwerte messwerte) {
        return messwerteRepository.saveMesswerte(messwerte);
    }

    @Override
    public List<Messwerte> fetchMesswerteList() {
        return messwerteRepository.findAll();
    }

    @Override
    public Messwerte fetchMesswerteById(Long MesswerteId) throws MesswerteNotFoundException {
        Optional <Messwerte> Messwerte = messwerteRepository.findById(MesswerteId);

        if (!Messwerte.isPresent()){

            throw new MesswerteNotFoundException("Messwerte not available");
        }

        return Messwerte.get();
    }

    @Override
    public void deleteMesswerteById(Long MesswerteId) {
        messwerteRepository.deleteById(MesswerteId);
    }

    @Override
    public Messwerte updateMesswerte(Long MesswerteId, Messwerte Messwerte) {

        Messwerte depDB = MesswerteRepository.findById(MesswerteId).get();

        if (Objects.nonNull(Messwerte.getMesswerteNameStation()) &&
                !"".equalsIgnoreCase(Messwerte.getMesswerteNameStation())) {

            depDB.setMesswerteNameStation(Messwerte.getMesswerteNameStation());

        }
        if (Objects.nonNull(Messwerte.getMesswerteCode()) &&
                !"".equalsIgnoreCase(Messwerte.getMesswerteCode())) {

            depDB.setMesswerteCode(Messwerte.getMesswerteCode());

        }

        if (Objects.nonNull(Messwerte.getMesswerteAddress()) &&
                !"".equalsIgnoreCase(Messwerte.getMesswerteAddress())) {

            depDB.setMesswerteAddress(Messwerte.getMesswerteAddress());

        }

        return MesswerteRepository.save(depDB);
    }

    @Override
    public Messwerte fetchMesswerteByName(String MesswerteNameStation) {
        return MesswerteRepository.findByMesswerteNameStationIgnoreCase(MesswerteNameStation);

    }
}
