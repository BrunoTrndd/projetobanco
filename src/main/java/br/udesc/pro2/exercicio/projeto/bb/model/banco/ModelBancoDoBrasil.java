package br.udesc.pro2.exercicio.projeto.bb.model.banco;

import br.udesc.pro2.exercicio.projeto.bb.ContaPoupanca;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelConta;

import java.util.ArrayList;
import java.util.List;

public class ModelBancoDoBrasil implements IBanco {
    private String nome;
    private int codigo;

    private static int geradorCodigoBanco = 0;
    private int geradorCodigoConta;
    List<IConta> contas;

    public ModelBancoDoBrasil(String nome){
        this.nome = nome;
        this.codigo = ++geradorCodigoBanco;
        this.geradorCodigoConta = 0;
        contas = new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public ModelConta criarContaCorrente(String nomeCorrentista){
        ModelConta contaCorrente = new ModelConta(++geradorCodigoConta, this, nomeCorrentista);
        contas.add(contaCorrente);
        return contaCorrente;
    }

    public ContaPoupanca criarContaPoupanca(String nomeCorrentista){
        ContaPoupanca contaPoupanca = new ContaPoupanca(++geradorCodigoConta, this, nomeCorrentista);
        contas.add(contaPoupanca);
        return contaPoupanca;
    }


    public IConta getConta(int codigo){
        for(IConta c: contas){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{" + "nome=" + nome + ", codigo=" + codigo + ", geradorCodigoConta=" + geradorCodigoConta + ", contas=" + contas + '}';
    }


}
