package it.bit.academy.academyBoot.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.bit.academy.academyBoot.model.Iscrizione;
import it.bit.academy.academyBoot.model.Student;

@Repository
public interface IscrizioneDao extends JpaRepository<Iscrizione, Integer>{
	@Query("select i from Iscrizione i where i.student.id = :idStudente and i.course.id= :idCorso")
	Optional<Iscrizione> findByCorsoAndStudente(@Param("idStudente")int idStudente, @Param("idCorso")int idCorso);
	
	@Modifying
	@Query(value="UPDATE iscrizione SET valutazione=:valutazione WHERE id=:id",nativeQuery = true)
	void updateValutazione(@Param("id")int id,@Param("valutazione")int valutazione);
	
}
