package com.project.airplane_reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class AirplaneReservationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirplaneReservationApplication.class, args);
	}

}
