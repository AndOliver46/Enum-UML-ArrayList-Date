package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	private String name;
	private WorkerLevel level;;
	private double baseSalary;
	
	List<HourContract> contracts = new ArrayList<>();

	public Worker(String name, WorkerLevel level, double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		int contractPos = contracts.indexOf(contract);
		contracts.remove(contractPos);
	}
	
	public double income(Integer yr, Integer mt) {
		double totalIncome = 0;
		
		for(int i = 0; i < contracts.size(); i++) {
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(contracts.get(i).getDate());
			
			int year = cal2.get(Calendar.YEAR);
			int month = cal2.get(Calendar.MONTH) + 1;
			
			if(month == mt && year == yr) {
				totalIncome += contracts.get(i).totalValue();
			}
		}
		return totalIncome + this.baseSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	
	
}
