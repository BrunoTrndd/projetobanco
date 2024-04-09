package br.udesc.pro2.exercicio.projeto.bb.exceptions;

public class SaldoInsuficienteException extends TransacaoException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}