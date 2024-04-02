package br.udesc.pro2.exercicio.projeto.bb.factory.banco;

import br.udesc.pro2.exercicio.projeto.bb.model.banco.IBanco;

public interface IFactoryBanco {

    IBanco criarBanco(String nome);

}
