import Service.Sistema_Bancario;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Sistema_Bancario sistema = new Sistema_Bancario();

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("==== Sistema Bancário ====");
            System.out.println("Escolha uma das opções a seguir");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Fazer Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Transferir Valores Entre Contas");
            System.out.println("5 - Ver Transações");
            System.out.println("6 - Sair");
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println(" ");
                    System.out.println("=== Criar Conta ===");

                    System.out.println("CPF: ");
                    int cpf_criar = scanner.nextInt();

                    System.out.println("Nome: ");
                    scanner.nextLine();
                    String nome_criar = scanner.nextLine();

                    sistema.criarConta(cpf_criar,nome_criar);
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("=== Fazer Depósito ===");

                    System.out.println("CPF: ");
                    int cpf_depositar = scanner.nextInt();

                    System.out.println("Valor: ");
                    int valor_depositar = scanner.nextInt();


                    sistema.fazerDeposito(cpf_depositar,valor_depositar);
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("=== Realizar Saque ===");

                    System.out.println("CPF: ");
                    int cpf_saque = scanner.nextInt();

                    System.out.println("Valor: ");
                    int valor_saque = scanner.nextInt();


                    sistema.realizarSaque(cpf_saque,valor_saque);
                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("=== Transferir Valores Entre Contas ===");

                    System.out.println("CPF pessoa 01: ");
                    int cpf1_tranfer = scanner.nextInt();

                    System.out.println("CPF pessoa 02: ");
                    int cpf2_tranfer = scanner.nextInt();

                    System.out.println("Valor: ");
                    int valor_tranfer = scanner.nextInt();


                    sistema.transferenciaEntreConta(cpf1_tranfer,cpf2_tranfer,valor_tranfer);
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("=== Ver Transações ===");

                    System.out.println("CPF: ");
                    int cpf_transacoes = scanner.nextInt();

                    sistema.verTransacoes(cpf_transacoes);
                    break;
                case 6:
                    System.out.println("Sistema Encerrado");
                    break;

            }

            System.out.println("Deseja fazer outra operação? (s/n) ");
            String continuar = scanner.next();

            if(continuar.split("")[0].isEmpty() || !continuar.split("")[0].toUpperCase(Locale.ROOT).equals("S")){
                System.out.println("Sistema Encerrado");
                break;
            }

        }








        sistema.criarConta(12345, "David", 100);
        sistema.criarConta(54321, "Maria", 50);


        sistema.fazerDeposito(12345,20);
        sistema.fazerDeposito(54321, 10);

        sistema.realizarSaque(12345,20);
        sistema.realizarSaque(54321, 10);

        sistema.transferenciaEntreConta(12345,54321, 50);

        sistema.verTransacoes(12345);
        sistema.verTransacoes(54321);

        scanner.close();

    }
}
