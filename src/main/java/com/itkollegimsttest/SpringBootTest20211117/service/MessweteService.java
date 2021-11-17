package com.itkollegimsttest.SpringBootTest20211117.service;

import com.itkollegimsttest.SpringBootTest20211117.entity.Messwerte;

import java.util.List;

public interface MessweteService {

    public Messwerte saveMesswerte(Messwerte messwerte);

    public List<Messwerte> fetchMesswerteist();

    public void deleteMessweteById(Long messwerteId);

    public Messwerte updateMesswerte(Long messwerteId, Messwerte messwerte);

    Messwerte fetchMesswerteByName(String messwerteName);

}