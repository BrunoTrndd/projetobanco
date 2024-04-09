package br.udesc.pro2.exercicio.projeto.bb.service.transacao.bo;

import br.udesc.pro2.exercicio.projeto.bb.exceptions.SaldoInsuficienteException;
import br.udesc.pro2.exercicio.projeto.bb.exceptions.TransacaoException;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.transacao.ModelTransacao;
import br.udesc.pro2.exercicio.projeto.bb.repositorio.ContaRepositorio;

public class ModelTransacaoBo {

    private final ContaRepositorio repositorio;

    private ModelTransacao transacao;

    public ModelTransacaoBo(ContaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void validaTransacao() throws TransacaoException {
        validaSaldoTransacao();
    }

    public void inicializarBo(IConta contaOrigem, IConta contaDestino, double valor) {
        this.transacao = ModelTransacao.Builder.create()
                            .contaOrigem(contaOrigem)
                            .contaDestino(contaDestino)
                            .valor(valor)
                            .build();
    }

    private void validaSaldoTransacao() throws TransacaoException {
        double saldo = repositorio.obterSaldoCliente(transacao.getContaOrigem());

        if (saldo < transacao.getValor()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transação");
        }
    }

    public void auditarTransacao() {
        repositorio.auditarTransacao(transacao);
    }




}
