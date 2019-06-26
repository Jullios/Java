public abstract class Employee {

	protected int id;
	protected String name;
	protected String type;
	protected String address;
	protected String payMethod;
	protected String paySchedule;
	protected double totalBalance;
	protected boolean syndicate;

	// Setters Methods
	protected void setId(int id) {
		this.id = id;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected void setType(String type) {
		this.type = type;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	protected void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	protected void setPaySchedule(String paySchedule) {
		this.paySchedule = paySchedule;
	}
	protected void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	protected void setSyndicate(boolean syndicate) {
		this.syndicate = syndicate;
	}

	// Getters Methods
	protected int getId() {
		return this.id;
	}
	protected String getName() {
		return this.name;
	}
	protected String getType() {
		return this.type;
	}
	protected String getAddress() {
		return this.address;
	}
	protected String getPayMethod() {
		return this.payMethod;
	}
	protected String getPaySchedule() {
		return this.paySchedule;
	}
	protected double getTotalBalance() {
		return totalBalance;
	}
	protected boolean getSyndicate() {
		return this.syndicate;
	}
	protected void viewEmployee() {
		System.out.println("Id: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("Type: " + this.type);
		System.out.println("Address: " + this.address);
		System.out.println("Pay Method: " + this.payMethod);
		System.out.println("Pay Schelude: " + this.paySchedule);
		System.out.println("Syndicate: " + this.syndicate);
	}

}