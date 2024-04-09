package br.udesc.pro2.exercicio.projeto.bb.service.transacao;

import br.udesc.pro2.exercicio.projeto.bb.exceptions.TransacaoException;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelConta;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelContaPoupanca;
import br.udesc.pro2.exercicio.projeto.bb.repositorio.ContaRepositorio;
import br.udesc.pro2.exercicio.projeto.bb.service.transacao.bo.ModelTransacaoBo;


public class TransacaoService {

    private final ModelTransacaoBo transacaoBo;
    private final ContaRepositorio repositorio;

    public TransacaoService(ContaRepositorio repositorio, ModelTransacaoBo modelTransacaoBo) {
        this.repositorio = repositorio;
        this.transacaoBo = modelTransacaoBo;
    }

    public String realizarTransacao(IConta contaOrigem, IConta contaDestino, double valor) {
        transacaoBo.inicializarBo(contaOrigem, contaDestino, valor);
        try {
            transacaoBo.validaTransacao();
            transacaoBo.auditarTransacao();
        } catch (TransacaoException e) {
             return e.getMessage();
        }
        return "Transacao realizada com sucesso";
    }

}