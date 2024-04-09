package br.udesc.pro2.exercicio.projeto.bb.repositorio;

import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.transacao.ModelTransacao;

public interface ContaRepositorio {
    double obterSaldoCliente(IConta cliente);

    void auditarTransacao(ModelTransacao transacao);
}
