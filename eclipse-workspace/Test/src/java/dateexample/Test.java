package java.dateexample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		String armisticeDate = "2016-05-24";
		 
		LocalDate aLD = LocalDate.parse(armisticeDate);
		System.out.println("Date: " + aLD);
		 
		String armisticeDateTime = "2016-05-24T11:50";
		 
		LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
		System.out.println("Date/Time: " + aLDT);

		String anotherDate = "24 Apr 2016";
		 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate random = LocalDate.parse(anotherDate, df);
		 
		System.out.println(anotherDate + " parses as " + random);
		
		LocalDateTime dateTime=LocalDateTime.now();
		LocalDate currentDate = LocalDate.from(dateTime);
		LocalTime currentTime = LocalTime.from(dateTime);

		//hour, minute and second are int
		LocalTime timeToSet = LocalTime.of(2, 57, 59);
		LocalDate dateToSet = LocalDate.of(1700, 12, 31);

		dateTime = LocalDateTime.of(currentDate, timeToSet);
		dateTime = LocalDateTime.of(dateToSet, currentTime);

		dateTime = LocalDateTime.of(dateToSet, timeToSet);

		
		anotherDate = "24.05.2016";
		 
		random = LocalDate.parse(anotherDate);//Run time Exception
		 
		System.out.println(anotherDate + " parses as " + random);
	}

}
