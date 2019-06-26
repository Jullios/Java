import java.util.Scanner;

public class Hourly extends Employee {

	private Scanner input = new Scanner(System.in);
	private double salaryHour;

	public void setSalaryHour(double salaryHour) {
		this.salaryHour = salaryHour;
	}
	public double getSalaryHour() {
		return this.salaryHour;
	}
	public void insertPointCard() {
		System.out.print("Worked Hours: ");
		int workedHours = input.nextInt();
		double money = workedHours * salaryHour;
		setTotalBalance(getTotalBalance() + money);
		System.out.println("Sucess!");
	}

}
