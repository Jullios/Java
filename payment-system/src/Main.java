import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static int option;
    static String aux;

    static String nome;
    static String endereco;
    static String id;
    static String tipo;
    static String salario;
    static String metodoPagamento;
    static String eSindicato = "N";
    static String idSindicato = "-1";
    static String taxaSindical = "-1";

    public static void newEmployee() {
        System.out.print("\nVamos lá!\n");
        System.out.print("Digite o nome: ");
        nome = input.nextLine();
        nome = input.nextLine();
        System.out.print("Digite o endereço: ");
        endereco = input.nextLine();

        System.out.println("Tipos de empregados: ");
        System.out.println("[1] - Horista");
        System.out.println("[2] - Assalariado");
        System.out.println("[3] - Comissionado");

        System.out.print("Escolha um tipo: ");
        option = input.nextInt();
        aux = input.nextLine();

        switch(option) {
            case 1:
                System.out.println("\nEmpregado Horista!");
                System.out.print("Digite o Salário/Hora: ");
                salario = input.nextLine();
                metodoPagamento = "semanalmente";
                break;
            case 2:
                System.out.println("\nEmpregado Assalariado!");
                System.out.print("Digite o Salário: ");
                salario = input.nextLine();
                metodoPagamento = "mensalmente";
                break;
            case 3:
                System.out.println("\nEmpregado Comissionado!");
                System.out.print("Digite a Comissão: ");
                salario = input.nextLine();
                metodoPagamento = "bi-semanalmente";
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.print("\nEmpregado adicionado!\n");
    }

    public static void main(String[] args) {
        int option;
        do {

            System.out.println("\n");
            System.out.println("[1] - Adição de um empregado");
            System.out.println("[0] - Sair");
            System.out.println("\n");

            System.out.print("Escolha uma opção: ");
            option = input.nextInt();

            switch(option) {
                case 1:
                    newEmployee();
                    break;

                case 0:
                    System.out.println("Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(option != 0);

    }
}