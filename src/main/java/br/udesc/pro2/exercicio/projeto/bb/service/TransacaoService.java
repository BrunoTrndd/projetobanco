package br.udesc.pro2.exercicio.projeto.bb.service;

import br.udesc.pro2.exercicio.projeto.bb.exceptions.SaldoInsuficienteException;
import br.udesc.pro2.exercicio.projeto.bb.repositorio.ContaRepositorio;

public class TransacaoService {
    private ContaRepositorio repositorio;

    public TransacaoService(ContaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void realizarTransacao(Long clienteId, double valor) {
        double saldo = repositorio.obterSaldoCliente(clienteId);
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transação");
        }

    }
}