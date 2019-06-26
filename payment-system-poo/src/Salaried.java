public class Salaried extends Employee {

	private double salaryMonth;
	private double salaryDay;

	public void setSalaryMonth(double salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public void setSalaryDay(double salaryDay) {
		this.salaryDay = salaryDay/24;
	}
	public double getSalaryMonth() {
		return this.salaryMonth;
	}
	public double getSalaryDay() {
		return this.salaryDay;
	}

}
