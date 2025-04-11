package Model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int cpf;
    private String nome;
    private float valor;
    private List<String> transacoes = new ArrayList<String>();

    public Conta(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Conta(int cpf, String nome, float valor) {
        this.cpf = cpf;
        this.nome = nome;
        this.valor = valor;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<String> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(String transacao) {
        this.transacoes.add(transacao);
    }
}