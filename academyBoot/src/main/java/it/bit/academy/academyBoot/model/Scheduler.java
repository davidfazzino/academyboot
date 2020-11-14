package it.bit.academy.academyBoot.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

	public Map<LocalDate,SlotOrarioLezione> generateSchedule(LocalDate start) {
		 Map<LocalDate,SlotOrarioLezione> calendario = new TreeMap<LocalDate, SlotOrarioLezione>();
		 LocalDate startDate=start;
		 int monteOre = 0;
		 DayOfWeek firstDay=start.getDayOfWeek();
		 DayOfWeek startDay=null;
		 int lastDayOfWeek = mappaOrari.keySet().stream().sorted((x1, x2) -> x2.getValue()-x1.getValue()).findFirst().get().getValue();
		
		 while(monteOre<modulo.getNumeroOre()) {
		  for (DayOfWeek day : mappaOrari.keySet()) {
			if(day.compareTo(firstDay)>=0 && monteOre<modulo.getNumeroOre()) {
				startDay=day;
				startDate = startDate.with(TemporalAdjusters.next(startDay));

				for(SlotOrarioLezione sol:mappaOrari.get(startDay)) {
					  calendario.put(startDate, sol);
					  monteOre+=ChronoUnit.HOURS.between(sol.getOraInizio(),sol.getOraFine());
				}
				if(day.getValue()==lastDayOfWeek) {
					firstDay=DayOfWeek.of(1);
				}else {
					firstDay=DayOfWeek.of(day.getValue()+1);
				}				
			}else {
				if(firstDay.getValue() > lastDayOfWeek) {
					firstDay=DayOfWeek.of(1);
				}
			}
		  }
		}
		return calendario;
	}
		
}
