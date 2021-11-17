package com.itkollegimsttest.SpringBootTest20211117.repository;

import com.itkollegimsttest.SpringBootTest20211117.entity.Messwerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesswerteRepository extends JpaRepository<Messwerte, Long> {
}
