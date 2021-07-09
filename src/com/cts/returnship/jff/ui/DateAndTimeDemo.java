package com.cts.returnship.jff.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateAndTimeDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a");
		
		ZonedDateTime floridaCurrent = ZonedDateTime.now (ZoneId.of("GMT-4"));
		
		ZonedDateTime singaporeCurrent = ZonedDateTime.now(ZoneId.of("GMT+8"));
		
		System.out.println("Current time in Singapore is: " + singaporeCurrent.format(formatter));
		System.out.println(floridaCurrent);
		
		System.out.println(floridaCurrent.format(formatter));
		System.out.println(currentTime.format(formatter));
		
		LocalDateTime indIndependence = LocalDateTime.of(1947, Month.AUGUST, 15, 0, 0);
		System.out.println( indIndependence.format(formatter));
		
		// measuring diff 2 dates
		Period p = Period.between(indIndependence.toLocalDate(), currentTime.toLocalDate());
		System.out.println(p);
		
		// measuring diff between times
		Duration d = Duration.between(indIndependence, currentTime);
		System.out.println(d);
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println("DOB(dd-MMM-yyyy:>");
		String doString = scan.next();
		
		LocalDate dob = LocalDate.parse(doString, formatter2);
		LocalDate dor = dob.plusYears(60);
		System.out.println(dor.format(formatter2));
		
		scan.close();
		
	}

}
