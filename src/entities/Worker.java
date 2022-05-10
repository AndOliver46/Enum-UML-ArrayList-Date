package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;;
	private double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}



	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(Integer year, Integer month) {
		double totalIncome = 0;
		
		for(int i = 0; i < contracts.size(); i++) {
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(contracts.get(i).getDate());
			
			int c_year = cal2.get(Calendar.YEAR);
			int c_month = cal2.get(Calendar.MONTH) + 1;
			
			if(c_month == month && c_year == year) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}	
}
