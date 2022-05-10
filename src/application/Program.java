package application;

import java.text.DateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {

		Worker worker;
		List<HourContract> contracts = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter department's name: ");
		System.out.println("Enter worker data: \n");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");	
		String level1 = sc.nextLine();
		WorkerLevel level2 = WorkerLevel.valueOf(level1);
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker: ");
		int contractNumber = sc.nextInt();
		
		for(int i = 0; i < contractNumber; i++) {
			System.out.println("Enter contract #" + (i+1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.nextLine();
			Date date1 = Date.from(Instant.parse(date));
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(date1, valuePerHour, duration);
			contracts.add(i, contract);
		}
		
		System.out.print("Enter the month and the year to calculate income (MM/YYYY): ");
		String monthYear = sc.nextLine();
		for(int i = 0; i < contracts.size(); i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contracts.get(i).getDate());
			
			if(cal.MONTH == )
	
		}
		System.out.print("Name: ");
		System.out.print("Name: ");

	}

}
