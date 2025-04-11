import Service.Sistema_Bancario;

public class Main {
    public static void main(String[] args){
        Sistema_Bancario sistema = new Sistema_Bancario();

        sistema.criarConta(12345, "David", 100);
        sistema.criarConta(54321, "Maria", 50);


        sistema.fazerDeposito(12345,20);
        sistema.fazerDeposito(54321, 10);

        sistema.realizarSaque(12345,20);
        sistema.realizarSaque(54321, 10);

        sistema.transferenciaEntreConta(12345,54321, 50);

        sistema.verTransacoes(12345);
        sistema.verTransacoes(54321);



    }
}
