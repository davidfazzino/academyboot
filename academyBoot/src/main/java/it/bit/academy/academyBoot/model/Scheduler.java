package it.bit.academy.academyBoot.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
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
		 LocalDate startDate=null;
		 int monteOre = 0;
		 DayOfWeek firstDay=start.getDayOfWeek();
		 DayOfWeek startDay=null;
		 //PROBLME
		 while(monteOre<=modulo.getNumeroOre()) {
		  for (DayOfWeek day : mappaOrari.keySet()) {
			if(day.compareTo(firstDay)>=0) {
				startDay=day;
				startDate=start.plusDays(startDay.getValue()-firstDay.getValue());
				
				 for(SlotOrarioLezione sol:mappaOrari.get(startDay)) {
					  calendario.put(startDate, sol);
					  monteOre+=ChronoUnit.HOURS.between(sol.getOraInizio(),sol.getOraFine());
					  
					 }
			}
			
			if(firstDay.getValue()==7) {
			firstDay=DayOfWeek.of(1);
			}else {
			firstDay=DayOfWeek.of(firstDay.getValue()+1);
			}
		 }
		}
		  System.out.println(startDay);
		
		  return calendario;
		 }
		
//		 if(mappaOrari.containsKey(start.getDayOfWeek())){
//			  for(SlotOrarioLezione sol:mappaOrari.get(start)) {
//				  mappaGiorniCal.put(start, sol);
//				  monteOre+=ChronoUnit.HOURS.between(sol.getOraFine(),sol.getOraInizio());
//				 
//			  }
//		 while(monteOre<=modulo.getNumeroOre()) {
//			  
//			 Set<DayOfWeek> keys=mappaOrari.keySet();
//				for(Iterator<DayOfWeek> i=keys.iterator();i.hasNext();) {
//					 for(SlotOrarioLezione sol:mappaOrari.get(i.next())) {
//						  mappaGiorniCal.put(start, sol);
//						  monteOre+=ChronoUnit.HOURS.between(sol.getOraFine(),sol.getOraInizio());
//						 
//					  }
//					
//					i.next();
//					 start=start.plusDays(i.next());
//					
					
					
				//}
				 //mappaOrari.get(start.getDayOfWeek());
		 
				  
			//}
		// }
	

}
