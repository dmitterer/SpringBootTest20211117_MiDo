package com.itkollegimsttest.SpringBootTest20211117.controller;

import com.itkollegimsttest.SpringBootTest20211117.entity.Messwerte;
import com.itkollegimsttest.SpringBootTest20211117.service.MesswerteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class MesswerteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private MesswerteService messwerteServiceesswerteService;

    private Messwerte messwerte;

    @BeforeEach
    void setUp() {

        messwerte = Messwerte.builder()
                .messwerteId(1)
                .messwertTemperatur(30)
                .messwerteNameStation("Innsbruck")
                .build();
    }

    @Test
    void saveMesswerte () throws Exception {
        messwerte inputMesswerte = Messwerte.builder()
                .messwerteId(1)
                .messwertTemperatur(30)
                .messwerteNameStation("Innsbruck")
                .build();

        Mockito.when(MesswerteService.saveMesswerte(inputMesswerte))
                .thenReturn(messwerte);

        mockMvc.perform(post("/Messwerte")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"MesswertTemmperatur\":\"30C\",\n" +
                        "\t\"MesswerteAddress\":\"Innsbruck\",\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchMesswerteById() throws Exception {

        Mockito.when(MesswerteService.fetchMesswerteById(1L))
                .thenReturn(messwerte);

        mockMvc.perform(get("/Messwertes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.MesswerteName").value(Messwerte.getMesswerteNameStation()));

}