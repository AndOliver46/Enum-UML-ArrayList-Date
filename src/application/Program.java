package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //Essa definição está especificando que esperamos uma data que contenha dia/mês/ano.
		
		System.out.print("Enter department's name: ");
		Department department = new Department(sc.nextLine());
		
		System.out.println("Enter worker data: \n");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");	
		String level1 = sc.nextLine();
		WorkerLevel level2 = WorkerLevel.valueOf(level1);
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, level2, baseSalary);
		
		System.out.print("How many contracts to this worker: ");
		int contractNumber = sc.nextInt();

		for(int i = 0; i < contractNumber; i++) {
			System.out.println("\nEnter contract #" + (i+1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			sc.nextLine();
			String dateStr = sc.nextLine();
			Date date = formatter.parse(dateStr);
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(date, valuePerHour, duration);
			worker.addContract(contract);
		}
		
		System.out.print("\nEnter the month and the year to calculate income (MM/YYYY): ");
		sc.nextLine();
		String monthYearIntput = sc.nextLine();
		
		SimpleDateFormat formatterMMYYY = new SimpleDateFormat("MM/yyyy"); //Essa definição está especificando que esperamos uma data que contenha dia/mês/ano.
		Date date = formatterMMYYY.parse(monthYearIntput);
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		
		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH) + 1;
		
		double income = worker.income(year, month);
		

		System.out.println("Name " + worker.getName()
				+ "\nDepartment: " + department.getName()
				+ "\nIncome for " + month + "/" + year + ": " + String.format("%.2f", income));
		
		sc.close();
	}

}
