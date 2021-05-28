package ch.zt.timerecorders.start;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.zt.timerecorders.persistence.MitarbeiterRepository;

import ch.zt.timerecorders.view.ViewsController;

@SpringBootApplication
@ComponentScan({ "ch.zt.timerecorders.persistence", "ch.zt.timerecorders.persistence",
		"ch.zt.timerecorders.businesslogic", "ch.zt.timerecorders.services", "ch.zt.timerecorders.view",
		"ch.zt.timerecorders.start", "ch.zt.timerecorders.database" }) // Referenz, wenn es in den verschiedenen
																		// Packages ist. (BR)
public class ZeiterfassungssystemTimeRecordersApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(ZeiterfassungssystemTimeRecordersApplication.class, args);
	}



}
