package com.itkollegimsttest.SpringBootTest20211117.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.Id;

@Controller
public class MesswerteController {

    @Id
    private int messwerteId;
    private int messwertTemperatur;
    private String messwerteNameStation;
}
