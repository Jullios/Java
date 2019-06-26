public interface Administrable {

	void insertSaleResults();
	void insertServiceFee();
	void insertPointCard();
	void editPaySchedule();
	void newPaySchedule();
	void removeEmployee(int id);
	void editEmployee(int id);
	void newEmployee();
	void viewEmployee(int id);
	void payroll();
	void undo();
	void redo();
	void header();
}
