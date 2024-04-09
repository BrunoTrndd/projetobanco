package br.udesc.pro2.exercicio.projeto.bb.model.conta;

public class ModelContaPoupanca implements IConta{

    public double saldo;
    public int codigo;

    @Override
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
