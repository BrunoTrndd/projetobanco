package br.udesc.pro2.exercicio.projeto.bb.factory.banco;

import br.udesc.pro2.exercicio.projeto.bb.model.banco.IBanco;
import br.udesc.pro2.exercicio.projeto.bb.model.banco.ModelBancoDoBrasil;

public class BancoDoBrasilFactory implements IFactoryBanco{

    @Override
    public IBanco criarBanco(String nome) {
        return new ModelBancoDoBrasil(nome);
    }

}