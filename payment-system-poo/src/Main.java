import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int menu;
    Administrable admin = new Admin();

    System.out.println("************************************************************");
    System.out.println("*******                 Administrator                *******");
    System.out.println("************************************************************");

    do {
      System.out.println();
      admin.header();
      System.out.println("[1] - NEW EMPLOYEE");
      System.out.println("[2] - REMOVE EMPLOYEE");
      System.out.println("[3] - EDIT EMPLOYEE");
      System.out.println("[4] - VIEW EMPLOYEE");
      System.out.println("[5] - INSERT POINT CARD");
      System.out.println("[6] - INSERT SALE RESULTS");
      System.out.println("[7] - INSERT SERVICE FEE");
      System.out.println("[8] - PAYROLL");
      System.out.println("[9] - UNDO");
      System.out.println("[10] - REDO");
      System.out.println("[11] - PAYMENT SCHEDULE");
      System.out.println("[12] - NEW PAYMENT SCHEDULE");

      System.out.println();
      System.out.println("MORE:");
      System.out.println("[13] - SETTINGS");
      System.out.println("[0]- QUIT");

      System.out.print("SELECT OPTION: ");
      menu = input.nextInt();

      System.out.println();
      if (menu == 1) admin.newEmployee();
      else if(menu == 8) admin.payroll();

    } while (menu != 0);
  }
}