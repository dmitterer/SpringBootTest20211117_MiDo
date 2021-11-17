package com.itkollegimsttest.SpringBootTest20211117.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Messwerte {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private int messwerteId;
    private int messwertTemperatur;
    @NotBlank(message = "Bitte Messstation angeben")
    private String messwerteNameStation;
}
