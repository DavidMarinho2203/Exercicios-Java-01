package Service;

import Model.Conta;

import java.util.ArrayList;
import java.util.List;

public class Sistema_Bancario {
    private List<Conta> contas = new ArrayList<Conta>();

    public void criarConta(int cpf, String nome){
        if(!verificarConta(cpf)){
            if (nome.isEmpty() || !nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("Nome inválido");
            } else {
                Conta newConta = new Conta(cpf,nome);
                contas.add(newConta);
                System.out.println("Conta criada com sucesso!");
            }
        }else{
            System.out.println("Já existe uma conta com esse CPF");
        }
    }

    public void criarConta(int cpf, String nome, float valor){
        if(!verificarConta(cpf)){
            if (nome.isEmpty() || !nome.matches("[a-zA-ZÀ-ÿ\\s]+") || valor < 0) {
                System.out.println("Dados inválidos");
            } else {
                Conta newConta = new Conta(cpf,nome,valor);
                contas.add(newConta);
                System.out.println("Conta criada com sucesso!");
            }
        }else{
            System.out.println("Já existe uma conta com esse CPF");
        }
    }

    public void fazerDeposito(int cpf, float valor){
        if(verificarConta(cpf)){
            Conta contaOrigem = null;
            for(Conta conta: contas){
                if(conta.getCpf() == cpf){
                    contaOrigem = conta;
                    break;
                }
            }
            if(contaOrigem != null){
                if(valor >= 10){
                    String transacao = "Depositou: " + valor;
                    contaOrigem.setTransacoes(transacao);
                    contaOrigem.setValor(contaOrigem.getValor() + valor);
                    System.out.println("Deposito realizado com sucesso");
                }else {
                    System.out.println("Deposito minimo 10 reais");
                }
            }
        }else{
            System.out.println("Não existe uma conta com esse CPF");
        }
    }

    public void realizarSaque(int cpf, float valor){
        if(verificarConta(cpf)){
            Conta contaOrigem = null;

            for(Conta conta: contas){
                if (conta.getCpf() == cpf) {
                    contaOrigem = conta;
                    break;
                }
            }

            if (contaOrigem != null) {
                if (contaOrigem.getValor() >= valor) {
                    String transacao = "Saque: R$" + valor;
                    contaOrigem.setTransacoes(transacao);
                    contaOrigem.setValor(contaOrigem.getValor() - valor);
                    System.out.println("Saque realizado com sucesso");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            }

        }else{
            System.out.println("Não existe uma conta com esse CPF");
        }
    }

    public void consultarSaldo(int cpf){
        if(!verificarConta(cpf)){
            for(Conta conta: contas){
                if(conta.getCpf() == cpf){
                    System.out.println("Saldo de " + conta.getNome() + " é de R$" + conta.getValor());
                }
            }
        }else{
            System.out.println("Não existe uma conta com esse CPF");
        }
    }

    public void transferenciaEntreConta(int cpf1, int cpf2, float valor) {
        if (verificarConta(cpf1) && verificarConta(cpf2)) {
            if (valor > 0) {
                Conta contaOrigem = null;
                Conta contaDestino = null;

                // Encontrar as contas
                for (Conta conta : contas) {
                    if (conta.getCpf() == cpf1) {
                        contaOrigem = conta;
                    } else if (conta.getCpf() == cpf2) {
                        contaDestino = conta;
                    }
                }

                // Verifica se encontrou as duas contas
                if (contaOrigem != null && contaDestino != null) {
                    if (contaOrigem.getValor() >= valor) {
                        // Atualiza saldos
                        contaOrigem.setValor(contaOrigem.getValor() - valor);
                        contaDestino.setValor(contaDestino.getValor() + valor);

                        // Registra transações
                        String transacaoOrigem = "Transferência Enviada: R$" + valor + " para " + contaDestino.getNome();
                        String transacaoDestino = "Transferência Recebida: R$" + valor + " de " + contaOrigem.getNome();

                        contaOrigem.setTransacoes(transacaoOrigem);
                        contaDestino.setTransacoes(transacaoDestino);
                    } else {
                        System.out.println("Valor insuficiente");
                    }
                }
            } else {
                System.out.println("Valor inválido!");
            }
        } else {
            System.out.println("Uma das contas está inválida");
        }
    }

    public void verTransacoes(int cpf){
        if(verificarConta(cpf)){
            Conta contaOrigem = null;
            for (Conta conta: contas){
                if(conta.getCpf() == cpf){
                    contaOrigem = conta;
                    break;
                }
            }
            if(contaOrigem != null){
                System.out.println(" ");
                System.out.println("===== Transferências =====");
                System.out.println("Conta de " + contaOrigem.getNome());
                for (String transacoes: contaOrigem.getTransacoes()){
                    System.out.println(transacoes);
                }
                System.out.println("===========================");
            }

        }
    }

    private boolean verificarConta(int cpf){
        for (Conta conta: contas){
            if(conta.getCpf() == cpf){
                return true;
            }
        }
        return false;
    }
}
