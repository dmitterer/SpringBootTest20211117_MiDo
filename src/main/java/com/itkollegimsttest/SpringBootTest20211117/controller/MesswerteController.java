package com.itkollegimsttest.SpringBootTest20211117.controller;

import com.itkollegimsttest.SpringBootTest20211117.entity.Messwerte;
import com.itkollegimsttest.SpringBootTest20211117.error.MesswerteNotFoundException;
import com.itkollegimsttest.SpringBootTest20211117.service.MesswerteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MesswerteController {
    @Autowired
    private MesswerteService messwerteService;

    private final Logger LOGGER = LoggerFactory.getLogger(MesswerteController.class);

    @PostMapping("/Messwertes")
    public Messwerte saveMesswerte(@Valid() @RequestBody Messwerte messwerte) {

        LOGGER.info("Inside saveMesswerte of MesswerteController");

        return messwerte.s(messwerte);

    }

    @GetMapping("/Messwertes")
    public List<Messwerte> fetchMesswerteList() {

        LOGGER.info("Inside fetchMesswerteList of MesswerteController");
        return messwerte.fetchMesswerteList();

    }

    @GetMapping("/Messwertes/{id}")
    public Messwerte fetchMesswerteById(@PathVariable("id") Long messwerteId) throws MesswerteNotFoundException {

        return messwerte.fetchMesswerteById(messwerteId);

    }

    @DeleteMapping("/Messwertes/{id}")
    public String deleteMesswerteById(@PathVariable("id") Long messwerteId){

        messwerte.deleteMesswerteById(messwerteId);
        return "Messwerte deleted Successfully";


    }
    @PutMapping("/Messwertes/{id}")
    public Messwerte updateMesswerte(@PathVariable("id") Long messwerteId,
                                       @RequestBody Messwerte messwerte){

        return messwerte.updateMesswerte(messwerteId, messwerte);

    }
    @GetMapping("/Messwertes/name/{name}")
    public Messwerte fetchMesswerteByName(@PathVariable("name")
                                                    String MesswerteName){
        return messwerte.fetchMesswerteByName(MesswerteName);


    }

}
