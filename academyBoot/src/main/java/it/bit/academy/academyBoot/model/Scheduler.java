package it.bit.academy.academyBoot.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Scheduler {
	private Modulo modulo;
	private Map<DayOfWeek,List<SlotOrarioLezione>> mappaOrari;
	
	public Scheduler(Modulo modulo) {
		this.modulo = modulo;
		this.mappaOrari=modulo.getListaPreferenzaCalendario().stream()
				.map(SlotOrarioLezione::new)
				.collect(Collectors.groupingBy(SlotOrarioLezione::getGiorno, TreeMap::new, Collectors.toList()));	
				}

	public void generateSchedule(LocalDate start) {
		 Map<LocalDate,SlotOrarioLezione> mappaGiorniCal = null;
		 int monteOre = 0;
		 Optional<DayOfWeek> day=mappaOrari.keySet().stream().filter(p->p==start.getDayOfWeek()).findFirst();
	
		 while(monteOre<=modulo.getNumeroOre()) {
			  
			  if(day.isPresent()){
				  for(SlotOrarioLezione sol:mappaOrari.get(start)) {
					  mappaGiorniCal.put(start, sol);
					  monteOre+=ChronoUnit.HOURS.between(sol.getOraFine(),sol.getOraInizio());
					 
				  }
				  
				  
				  
					 
			}
		 }
	}

}
