package br.udesc.pro2.exercicio.projeto.bb.model.conta;


import br.udesc.pro2.exercicio.projeto.bb.model.banco.IBanco;

public class ModelConta implements IConta {
    
    private int codigo;
    private IBanco banco;
    private String nomeCorrentista;
    protected float saldo;

    public ModelConta(int codigo, IBanco banco, String nomeCorrentista) {
        this.banco = banco;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = 0.0f;
        this.codigo = codigo;
    }
    
    public void deposita(float valor){
        this.saldo += valor;
    }
    
    public boolean saque(float valor){
        this.saldo -= valor;
        return true;
    }

    public IBanco getBanco() {
        return banco;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Conta{" + "codigo=" + codigo + ", nomeCorrentista=" + nomeCorrentista + ", saldo=" + saldo + '}';
    }
    
}
