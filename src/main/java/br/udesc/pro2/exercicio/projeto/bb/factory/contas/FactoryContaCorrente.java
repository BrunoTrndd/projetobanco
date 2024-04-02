package br.udesc.pro2.exercicio.projeto.bb.factory.contas;

import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelContaCorrente;

public class FactoryContaCorrente extends FactoryContas {

    @Override
    public IConta criarConta() {
        return new ModelContaCorrente();
    }

}
