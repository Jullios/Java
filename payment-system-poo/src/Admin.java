import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin implements Administrable {

	private Scanner input = new Scanner(System.in);
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Integer> idEmployee = new ArrayList<>();
	private CalPay calendar = new CalPay();

	public void insertSaleResults() {}
	public void insertServiceFee() {}
	public void insertPointCard() {}
	public void editPaySchedule() {}
	public void newPaySchedule() {}
	public void removeEmployee(int id) {
		boolean exist = existEmployee(id);
		if(exist) {
			int iIdEmployee = indexIdEmployee(id);
			this.idEmployee.remove(iIdEmployee);
			int iEmployee = indexEmployee(id);
			this.employees.remove(iEmployee);
			this.calendar.pay(id);
			this.calendar.remove(id);
			System.out.println("REMOVED");
		}
		else System.out.println("NOT REMOVED");
	}
	public void editEmployee(int id) {}
	public void newEmployee() {

		String name;
		String type;
		String address;
		String payMethod;
		String paySchedule;
		double totalSalary;
		Employee employee;
		int i, confirm;

		System.out.println();
		System.out.println("NEW EMPLOYEE");

		System.out.print("NAME: ");
		name = input.nextLine().toUpperCase();

		System.out.print("ADDRESS: ");
		address = input.nextLine().toUpperCase();

		System.out.println();
		System.out.println("[1] - SALARIED");
		System.out.println("[2] - COMMISSIONED");
		System.out.println("[3] - HOURLY");
		System.out.print("T. EMPLOYEE(DEFAULT: [1]): ");
		i = input.nextInt();

		if (i == 3) {
			type = "HOURLY";
			paySchedule = "SEMANALMENTE";

			System.out.println();
			System.out.print("SALARY/HOUR: ");
			totalSalary = input.nextDouble();
			employee = new Hourly();

		} else if (i == 2) {
			type = "COMMISSIONED";
			paySchedule = "BI-SEMANALMENTE";

			System.out.println();
			System.out.print("SALARY/MONTH: ");
			totalSalary = input.nextDouble();

			System.out.print("PERCENTAGE SALES: ");
			double percentSales = input.nextDouble();
			employee = new Commissioned();

		} else {
			type = "SALARIED";
			paySchedule = "MENSALMENTE";

			System.out.println();
			System.out.print("SALARY/MONTH: ");
			totalSalary = input.nextDouble();
			employee = new Salaried();
		}

		System.out.println();
		System.out.println("[1] - DEPOSIT: BANK ACCOUNT");
		System.out.println("[2] - CHECK: POST OFFICE");
		System.out.println("[3] - CHECK: HANDS");
		System.out.print("PAY METHOD(DEFAULT: [1]): ");
		i = input.nextInt();

		if (i == 1) {
			payMethod = "BANK";
		} else if (i == 2) {
			payMethod = "OFFICE";
		} else if (i == 3) {
			payMethod = "HANDS";
		} else {
			payMethod = "BANK";
		}

		System.out.println();
		System.out.print("CONFIRM[1/0]: ");
		confirm = input.nextInt();

		if(confirm == 1) {
			employee.setId(newIdEmployee());
			employee.setName(name);
			employee.setType(type);
			employee.setAddress(address);
			employee.setPayMethod(payMethod);
			employee.setPaySchedule(paySchedule);
			employee.setSyndicate(false);
			boolean verify;
			if(employee instanceof Hourly) {
				((Hourly) employee).setSalaryHour(totalSalary);
				verify = this.calendar.add(employee.getId(), 1, "FRIDAY");
			}
			else if(employee instanceof Salaried) {
				((Salaried) employee).setSalaryMonth(totalSalary);
				((Salaried) employee).setSalaryDay(totalSalary);
				verify = this.calendar.add(employee.getId(), 1, 31);
			}
			else {
				verify = this.calendar.add(employee.getId(), 2, "FRIDAY");
			}

			if(verify) {
				this.employees.add(employee);
				System.out.println("REGISTERED");
			}
			else {
				System.out.println("UNREGISTERED");
			}
		} else {
			System.out.println("UNREGISTERED");
		}

	}
	public void viewEmployee(int id) {

		employees.get(0).viewEmployee();
	}
	public void payroll(){
		System.out.println("[1] - VIEW PAYROLL");
		System.out.println("[2] - RUN PAYROLL");
		System.out.print("OPTION(DEFAULT: [1]): ");
		int i = input.nextInt();
		System.out.println();
		if(i == 2) this.calendar.pay();
		else this.calendar.viewCalendar();
	}
	public void undo() {}
	public void redo() {}
	public void header() {
		int tEmployee = this.employees.size();
		int day = this.calendar.getActualDay();
		int month = this.calendar.getActualMonth();
		int year = this.calendar.getActualYear();
		System.out.print("COMPANY: BLUE\t\t");
		System.out.printf("EMPLOYEES TOTAL: %d\t\t", tEmployee);
		System.out.printf("DATE: %d/%d/%d\n\n", day, month, year);
	}

	private boolean existEmployee(int id) {

		return this.idEmployee.contains(id);
	}
	private int indexEmployee(int id) {
		for(int i = 0; i < this.employees.size(); i++) {
			if(id == this.employees.get(i).getId()) return i;
		}
		return -1;
	}
	private int indexIdEmployee(int id) {
		for(int i = 0; i < this.idEmployee.size(); i++) {
			if(id == this.idEmployee.get(i)) return i;
		}
		return -1;
	}
	private int newIdEmployee() {
		Random generator = new Random();
		int id;
		do {
			id = generator.nextInt(1000);
		}
		while(this.idEmployee.contains(id));
		this.idEmployee.add(id);
		return id;
	}

}