package it.bit.academy.academyBoot.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SchedulerTest {
	private Scheduler scheduler;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Modulo m=new Modulo();
		PreferenzeCalendario p1= new PreferenzeCalendario(m, DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
		PreferenzeCalendario p2= new PreferenzeCalendario(m, DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
		PreferenzeCalendario p3= new PreferenzeCalendario(m, DayOfWeek.FRIDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
		List<PreferenzeCalendario> listaPrefe=new ArrayList<>(List.of(p1,p2,p3));
		m.setListaPreferenzaCalendario(listaPrefe);
		m.setNumeroOre(12);
		scheduler=new Scheduler(m);
		}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void generateScheduleTest() {
		LocalDate startDate=LocalDate.of(2020, 11, 12);
		Map<LocalDate,SlotOrarioLezione> calendario=scheduler.generateSchedule(startDate);
		LocalDate expected=LocalDate.of(2020, 11, 13);
		assertEquals(expected, calendario.keySet().stream().findFirst().get());
		LocalDate lastExpected = LocalDate.of(2020, 11, 25);
		assertEquals(lastExpected, calendario.keySet().stream().sorted((x1, x2) -> x2.compareTo(x1)).findFirst().get());
		assertEquals(6, calendario.size());
		
	}

}
