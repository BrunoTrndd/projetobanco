package br.udesc.pro2.exercicio.projeto.bb;

import br.udesc.pro2.exercicio.projeto.bb.model.banco.ModelBancoDoBrasil;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelConta;

public class ContaPoupanca extends ModelConta {

    public ContaPoupanca(int codigo, ModelBancoDoBrasil banco, String nomeCorrentista) {
        super(codigo, banco, nomeCorrentista);
    }


    @Override
    public boolean saque(float valor){
        if(saldo - valor < 0.0){
            System.out.println("Não foi possível realizar o saque");
            return false;
        }
        else {
            return super.saque(valor);
        }

    }

    @Override
    public String toString() {
        return "Conta{" + "codigo=" + getCodigo() + ", nomeCorrentista=" + getNomeCorrentista() + ", saldo=" + getSaldo() + ", Tipo=Poupança" + '}';
    }

}
