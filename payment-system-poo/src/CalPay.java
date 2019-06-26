import java.util.ArrayList;
import java.util.Calendar;

public class CalPay {

	private int actualDay;
	private int actualWeek;
	private int actualMonth;
	private int actualYear;
	private int totalDaysMonth;
	private Calendar gCalendar = Calendar.getInstance();
	private ArrayList<ArrayList<ArrayList<Integer>>> calendar = new ArrayList<>();

	public CalPay() {

		setActualDay(this.gCalendar.get(Calendar.DAY_OF_MONTH));
		setActualWeek(this.gCalendar.get(Calendar.WEEK_OF_MONTH));
		setActualMonth(this.gCalendar.get(Calendar.MONTH));
		setActualYear(this.gCalendar.get(Calendar.YEAR));
		setTotalDaysMonth(this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		for (int i = 0; i < 12; i++) {

			ArrayList<ArrayList<Integer>> month = new ArrayList<>();
			this.calendar.add(month);

			this.gCalendar.set(Calendar.MONTH, i);
			int totalDaysMonth = this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

			for (int j = 0; j < totalDaysMonth; j++) {
				ArrayList<Integer> day = new ArrayList<>();
				this.calendar.get(i).add(day);
			}
		}

		this.gCalendar.set(Calendar.MONTH, getActualMonth());

	}
	public boolean add(int id, int frequencyMonth, int day) {

		if ((getActualMonth() + frequencyMonth >= 12) || (frequencyMonth == 0)) return false;
		if (day < 28) {

			for (int i = getActualMonth() + frequencyMonth; i < 12; i += frequencyMonth) {
				this.calendar.get(i).get(day).add(id);
			}

			return true;

		} else {

			System.out.println("PAY DAY: LAST DAY");

			for (int i = getActualMonth() + frequencyMonth; i < 12; i += frequencyMonth) {
				this.gCalendar.set(Calendar.MONTH, i);
				int totalDaysMonth = this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				this.calendar.get(i).get(totalDaysMonth - 1).add(id);
			}

			this.gCalendar.set(Calendar.MONTH, getActualMonth());
			return true;

		}
	}
	public boolean add(int id, int frequencyWeek, String day) {

		int kDay, weekDay, monthDay, month, year;
		if (day.equals("SUNDAY")) kDay = 1;
		else if (day.equals("MONDAY")) kDay = 2;
		else if (day.equals("TUESDAY")) kDay = 3;
		else if (day.equals("WEDNESDAY")) kDay = 4;
		else if (day.equals("THURSDAY")) kDay = 5;
		else if (day.equals("FRIDAY")) kDay = 6;
		else kDay = 7;

		this.gCalendar.add(Calendar.WEEK_OF_MONTH, frequencyWeek);
		month = this.gCalendar.get(Calendar.MONTH);
		year = this.gCalendar.get(Calendar.YEAR);


		if(month >= 12) {
			this.gCalendar.add(Calendar.WEEK_OF_MONTH, frequencyWeek);
			return false;
		}

		while(month < 12 && year == getActualYear()) {

			weekDay = this.gCalendar.get(Calendar.DAY_OF_WEEK);
			if(weekDay == kDay) {
				monthDay = this.gCalendar.get(Calendar.DAY_OF_MONTH);
				this.calendar.get(month).get(monthDay).add(id);
				this.gCalendar.add(Calendar.WEEK_OF_MONTH, frequencyWeek);
			} else {
				this.gCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}

			month = this.gCalendar.get(Calendar.MONTH);
			year = this.gCalendar.get(Calendar.YEAR);
		}

		this.gCalendar.set(Calendar.DAY_OF_MONTH, getActualDay());
		this.gCalendar.set(Calendar.MONTH, getActualMonth());
		this.gCalendar.set(Calendar.YEAR, getActualYear());
		return true;
	}
	public void remove(int id) {

		for(int i = 0; i < 12; i++) {

			this.gCalendar.set(Calendar.MONTH, i);
			int totalDaysMonth = this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

			for(int j = 0; j < totalDaysMonth; j++) {

				for(int k = 0; k < this.calendar.get(i).get(j).size(); k++) {
					int n = this.calendar.get(i).get(j).get(k);
					if(id == n) {
						this.calendar.get(i).get(j).remove(k);
					}
				}
			}
		}

		this.gCalendar.set(Calendar.MONTH, this.actualMonth);

	}
	public void pay(int id) {}
	public void pay() {
		int month = getActualMonth();
		int day = getActualDay();
		int tPayments = calendar.get(month).get(day - 1).size();
		for(int id: calendar.get(month).get(day - 1)) {
			System.out.println("EMPLOYEE ID: " + id);
		}
		System.out.println("PAID EMPLOYEES: " + tPayments);
		this.gCalendar.add(Calendar.DAY_OF_MONTH, 1);
		setActualDay(this.gCalendar.get(Calendar.DAY_OF_MONTH));
		setActualWeek(this.gCalendar.get(Calendar.WEEK_OF_MONTH));
		setActualMonth(this.gCalendar.get(Calendar.MONTH));
		setActualYear(this.gCalendar.get(Calendar.YEAR));
		setTotalDaysMonth(this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	public void viewCalendar() {

		for(int i = 0; i < 12; i++) {

			this.gCalendar.set(Calendar.MONTH, i);
			int totalDaysMonth = this.gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

			System.out.println("\nMês: " + i + 1);

			for(int j = 0; j < totalDaysMonth; j++) {

				if(!this.calendar.get(i).get(j).isEmpty()) {
					System.out.printf("\tDia: %d | ID's: ", j);
					for (int k : this.calendar.get(i).get(j)) {
						System.out.printf("%d ", k);
					}

					System.out.println();
				}
			}

			System.out.println();

		}

		this.gCalendar.set(Calendar.MONTH, this.actualMonth);

	}

	public void setActualDay(int day) {
		this.actualDay = day;
	}
	public void setActualWeek(int week) {
		this.actualWeek = week;
	}
	public void setActualMonth(int month) {
		this.actualMonth = month;
	}
	public void setActualYear(int year) {
		this.actualYear = year;
	}
	public void setTotalDaysMonth(int days) {
		this.totalDaysMonth = days;
	}
	public int getActualDay() {
		return this.actualDay;
	}
	public int getActualWeek() {
		return this.actualWeek;
	}
	public int getActualMonth() {
		return this.actualMonth;
	}
	public int getActualYear() {
		return this.actualYear;
	}
	public int getTotalDaysMonth() {
		return this.totalDaysMonth;
	}

}