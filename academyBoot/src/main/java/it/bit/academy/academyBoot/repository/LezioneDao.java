package it.bit.academy.academyBoot.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import it.bit.academy.academyBoot.model.Lezione;
@Repository
public interface LezioneDao extends JpaRepository<Lezione, Integer> {
      List<Lezione> findByAula(String nomeAula);
      List<Lezione> findByModulo(String modulo);
      @Query("select l from Lezione l where l.dataInizio= :date and l.aula.id=:nomeAula")
      Optional<Lezione> findByAulaAndGiorno( @Param("date") LocalDateTime date, @Param("nomeAula") String nomeAula);
	
}
