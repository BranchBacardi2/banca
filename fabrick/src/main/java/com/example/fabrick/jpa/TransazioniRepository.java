package com.example.fabrick.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransazioniRepository extends JpaRepository<TransazioniEntity, Long> {
}
