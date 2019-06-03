import java.util.Scanner;

class Main {
	public static Scanner input = new Scanner(System.in);

	public static int getNewId(String[] idsEmployee, int maxPeople) {
		for (int i = 0; i < maxPeople; i++) {
			if (idsEmployee[i] == "0") {
				idsEmployee[i] = "1";
				return i;
			}
		}
		return -1;
	}

	public static int newEmployee(int maxPeople, String[][] mEmployee, String[] idsEmployee, String[] idsSyndicate, int tPeople) {

		String[] people;
		int idEmployee;

		String name = "";
		String address = "";
		String typeEmployee = "";
		String paymentMethod = "";
		int syndicate = 0;
		int idsEmployeeyndicate = -1;
		int syndicateRate = 0;
		int optionType = 0;
		String optionOk;

		idEmployee = getNewId(idsEmployee, maxPeople);
		System.out.print("Name: ");
		name = input.nextLine();
		name = input.nextLine();
		System.out.print("Address: ");
		name = input.nextLine();

		do {
			System.out.println("[1] - Commissioned");
			System.out.println("[2] - Salaried");
			System.out.println("[3] - Hourly");
			System.out.print("T. Employee: ");
			optionType = input.nextInt();

			if (optionType == 1) {
				typeEmployee = "Commissioned";
				paymentMethod = "bi-semanalmente";
			} else if (optionType == 2) {
				typeEmployee = "Salaried";
				paymentMethod = "mensalmente";
			} else if (optionType == 3) {
				typeEmployee = "Hourly";
				paymentMethod = "semanalmente";
			} else optionType = 0;
		} while (optionType == 0);


		System.out.printf("\nID: %d\n", idEmployee);
		System.out.printf("Name: %s\n", name);
		System.out.printf("Address: %s\n", address);
		System.out.printf("T. Employee: %s\n", typeEmployee);
		System.out.printf("P. Method: %s\n", paymentMethod);
		System.out.printf("Syndicate: %d\n", syndicate);
		System.out.printf("\nConfirm[Y/n]: ");
		optionOk = input.nextLine();
		optionOk = input.nextLine();

		return tPeople + 1;
	}

	public static void main(String[] args) {
		System.out.print("Enter the number of employees: ");
		int maxPeople = input.nextInt();

		int tPeople = 0;
		int menu;

		String[][] mEmployee = new String[maxPeople][256];
		String[] idsEmployee = new String[maxPeople];
		String[] idsSyndicate = new String[maxPeople];

		String[][][] undoPeople = new String[maxPeople][maxPeople][256];
		String[][][] redoPeople = new String[maxPeople][maxPeople][256];


		int[][] undoIdsEmployee = new int[maxPeople][maxPeople];
		int[][] undoIdsSyndicate = new int[maxPeople][maxPeople];
		int[][] redoIdsEmployee = new int[maxPeople][maxPeople];
		int[][] redoIdsSyndicate = new int[maxPeople][maxPeople];
		int[] undoVerify = new int[maxPeople];
		int[] redoVerify = new int[maxPeople];

		do {
			if (tPeople < maxPeople) {
				System.out.println("[1] - New People");
			}
			System.out.println("[2] - Edit People");
			System.out.println("[3] - Remove  People");
			System.out.println("[4] - View All People");
			System.out.println("[0]- Quit");

			System.out.print("Select option: ");
			menu = input.nextInt();

			if (menu == 1) tPeople = newEmployee(maxPeople, mEmployee, idsEmployee, idsSyndicate, tPeople);
			//if(menu == 2) editPeople(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify);
			//if(menu == 3) removePeople(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify, &tPeople);

			//if(menu == 4) viewAllPeople(mPeople, maxPeople);
			if (menu == 0) System.out.print("Thanks\n");

		} while (menu != 0);

	}
}